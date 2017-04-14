package com.wxy.frame.springboot.starter.motan;

import com.weibo.api.motan.config.ExtConfig;
import com.weibo.api.motan.config.springsupport.*;
import com.wxy.frame.springboot.starter.motan.properties.BasicRefererConfigProperties;
import com.wxy.frame.springboot.starter.motan.properties.BasicServiceConfigProperties;
import com.wxy.frame.springboot.starter.motan.properties.ProtocolConfigProperties;
import com.wxy.frame.springboot.starter.motan.properties.RegistryConfigProperties;
import com.wxy.frame.springboot.starter.motan.support.BasicServiceConfigCondition;
import com.wxy.frame.springboot.starter.motan.util.ConfConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import com.wxy.frame.cms.commons.utils.BeanUtil;
/**
 * @Description: com.wxy.frame.springboot.starter.motan
 * @date 2017/4/14.
 * Created by 石头 on 2017/4/14.
 */
@Configuration
@ConditionalOnClass({ProtocolConfigBean.class})
@EnableConfigurationProperties({RegistryConfigProperties.class,ProtocolConfigProperties.class,BasicServiceConfigProperties.class,BasicRefererConfigProperties.class})
public class MotanAutoConfig {
    public MotanAutoConfig(){
        System.out.println("-----------------MotanAutoConfig>-------------------------");
    }
    @Bean
    public AnnotationBean annotationBean(@Value("${motan.annotation.package}") String scanPackage){
        AnnotationBean annotationBean = new AnnotationBean();
        if (!StringUtils.isEmpty(scanPackage)){
            annotationBean.setPackage(scanPackage);
        }
        return annotationBean;
    }

    @Bean(name = ConfConstants.REGISTRY_CONFIG_BEAN_NAME)
    public RegistryConfigBean registryConfig(RegistryConfigProperties registryConfig) {
        RegistryConfigBean config = new RegistryConfigBean();
        config.setName(ConfConstants.REGISTRY_CONFIG_BEAN_NAME);

        BeanUtil.copyProperties(registryConfig,config);

        return config;
    }

    @Bean(name = ConfConstants.PROTOCOL_CONFIG_BEAN_NAME)
    public ProtocolConfigBean protocolConfig(ProtocolConfigProperties protocolConfig) {
        ProtocolConfigBean protocolConfigBean = new ProtocolConfigBean();
        BeanUtil.copyProperties(protocolConfig,protocolConfigBean);

        if (StringUtils.isEmpty(protocolConfigBean.getName())){
            protocolConfigBean.setName("motan");
        }

        return protocolConfigBean;
    }

    @Bean
    @Conditional(BasicServiceConfigCondition.class)
    public BasicServiceConfigBean baseServiceConfig(BasicServiceConfigProperties basicServiceConfig, RegistryConfigBean registryConfigBean){
        BasicServiceConfigBean configBean = new BasicServiceConfigBean();
        BeanUtil.copyProperties(basicServiceConfig,configBean);

        if (StringUtils.isEmpty(basicServiceConfig.getExport())) {
            if (StringUtils.isEmpty(basicServiceConfig.getExportPort())) {
                throw new RuntimeException("need service export port...");
            }
            configBean.setExport(ConfConstants.PROTOCOL_CONFIG_BEAN_NAME + ":" + basicServiceConfig.getExportPort());
        }

        if (!StringUtils.isEmpty(basicServiceConfig.getExtConfigId())) {
            ExtConfig extConfig = new ExtConfig();
            extConfig.setId(basicServiceConfig.getExtConfigId());
            configBean.setExtConfig(extConfig);
        }

        if (!StringUtils.isEmpty(basicServiceConfig.getRegistry())) {
            // 追加内部的注册配置bean
            configBean.setRegistry(ConfConstants.REGISTRY_CONFIG_BEAN_NAME + "," + basicServiceConfig.getRegistry());
        }else{
            configBean.setRegistry(ConfConstants.REGISTRY_CONFIG_BEAN_NAME);
        }
        return configBean;
    }

    @Bean
    public BasicRefererConfigBean baseRefererConfig(BasicRefererConfigProperties basicRefererConfig) {
        BasicRefererConfigBean configBean = new BasicRefererConfigBean();
        BeanUtil.copyProperties(basicRefererConfig,configBean);

        configBean.setProtocol(ConfConstants.PROTOCOL_CONFIG_BEAN_NAME);

        if (!StringUtils.isEmpty(basicRefererConfig.getRegistry())) {
            // 追加内部的注册配置bean
            configBean.setRegistry(ConfConstants.REGISTRY_CONFIG_BEAN_NAME + "," + basicRefererConfig.getRegistry());
        }else{
            configBean.setRegistry(ConfConstants.REGISTRY_CONFIG_BEAN_NAME);
        }

        if (!StringUtils.isEmpty(basicRefererConfig.getExtConfigId())) {
            ExtConfig extConfig = new ExtConfig();
            extConfig.setId(basicRefererConfig.getExtConfigId());
            configBean.setExtConfig(extConfig);
        }

        return configBean;
    }
}
