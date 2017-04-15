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
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan
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
//        if (registryConfig.getPort() != null) {
//            config.setPort(registryConfig.getPort());
//        }
//        if (registryConfig.getConnectTimeout() != null) {
//            config.setConnectTimeout(registryConfig.getConnectTimeout());
//        }
//        if (registryConfig.getRequestTimeout() != null) {
//            config.setRequestTimeout(registryConfig.getRequestTimeout());
//        }
//        if (registryConfig.getRegistrySessionTimeout() != null) {
//            config.setRegistrySessionTimeout(registryConfig.getRegistrySessionTimeout());
//        }
//        if (registryConfig.getRegistryRetryPeriod() != null) {
//            config.setRegistryRetryPeriod(registryConfig.getRegistryRetryPeriod());
//        }
//        if (!StringUtils.isEmpty(registryConfig.getCheck())) {
//            config.setCheck(registryConfig.getCheck());
//        }
//        if (registryConfig.getRegister() != null) {
//            config.setRegister(registryConfig.getRegister());
//        }
//        if (registryConfig.getSubscribe() != null) {
//            config.setSubscribe(registryConfig.getSubscribe());
//        }
//        if (registryConfig.getDefaultConfig() != null) {
//            config.setDefault(registryConfig.getDefaultConfig());
//        }
        return config;
        //return config;
    }

    @Bean(name = ConfConstants.PROTOCOL_CONFIG_BEAN_NAME)
    public ProtocolConfigBean protocolConfig(ProtocolConfigProperties protocolConfig) {
        ProtocolConfigBean protocolConfigBean = new ProtocolConfigBean();
        BeanUtil.copyProperties(protocolConfig,protocolConfigBean);

        if (StringUtils.isEmpty(protocolConfigBean.getName())){
            protocolConfigBean.setName("motan");
        }
//        if(StringUtils.isEmpty(protocolConfig.getSerialization())) {
//            protocolConfigBean.setSerialization(protocolConfig.getSerialization());
//        }
//        config.setpayload
//        config.setuffer
//        config.sethearbeat
//        config.settransporter
//        config.setthreads
//        if (protocolConfig.getIothreads() != null) {
//            protocolConfigBean.setIothreads(protocolConfig.getIothreads());
//        }
//        if (protocolConfig.getRequestTimeout() != null) {
//            protocolConfigBean.setRequestTimeout(protocolConfig.getRequestTimeout());
//        }
//        if (protocolConfig.getMinClientConnection() != null) {
//            protocolConfigBean.setMinClientConnection(protocolConfig.getMinClientConnection());
//        }
//        if (protocolConfig.getMaxClientConnection() != null) {
//            protocolConfigBean.setMaxClientConnection(protocolConfig.getMaxClientConnection());
//        }
//        if (protocolConfig.getMinWorkerThread() != null) {
//            protocolConfigBean.setMinWorkerThread(protocolConfig.getMinWorkerThread());
//        }
//        if (protocolConfig.getMaxClientConnection() != null) {
//            protocolConfigBean.setMaxClientConnection(protocolConfig.getMaxClientConnection());
//        }
//        if (protocolConfig.getMaxContentLength() != null) {
//            protocolConfigBean.setMaxContentLength(protocolConfig.getMaxContentLength());
//        }
//        if (protocolConfig.getMaxServerConnection() != null) {
//            protocolConfigBean.setMaxServerConnection(protocolConfig.getMaxServerConnection());
//        }
//        if (protocolConfig.getPoolLifo() != null) {
//            protocolConfigBean.setPoolLifo(protocolConfig.getPoolLifo());
//        }
//        if (protocolConfig.getLazyInit() != null) {
//            protocolConfigBean.setLazyInit(protocolConfig.getLazyInit());
//        }
//        if (!StringUtils.isEmpty(protocolConfig.getEndpointFactory())) {
//            protocolConfigBean.setEndpointFactory(protocolConfig.getEndpointFactory());
//        }
//        if (!StringUtils.isEmpty(protocolConfig.getCluster())) {
//            protocolConfigBean.setCluster(protocolConfig.getCluster());
//        }
//        if (!StringUtils.isEmpty(protocolConfig.getLoadbalance())) {
//            protocolConfigBean.setLoadbalance(protocolConfig.getLoadbalance());
//        }
//        if (!StringUtils.isEmpty(protocolConfig.getHaStrategy())) {
//            protocolConfigBean.setHaStrategy(protocolConfig.getHaStrategy());
//        }
//        if (protocolConfig.getWorkerQueueSize() != null) {
//            protocolConfigBean.setWorkerQueueSize(protocolConfig.getWorkerQueueSize());
//        }
//        if (protocolConfig.getAcceptConnections() != null) {
//            protocolConfigBean.setAcceptConnections(protocolConfig.getAcceptConnections());
//        }
//        if (!StringUtils.isEmpty(protocolConfig.getProxy())) {
//            protocolConfigBean.setProxy(protocolConfig.getProxy());
//        }
//        if (!StringUtils.isEmpty(protocolConfig.getFilter())) {
//            protocolConfigBean.setFilter(protocolConfig.getFilter());
//        }
//        if (protocolConfig.getRetries() != null) {
//            protocolConfigBean.setRetries(protocolConfig.getRetries());
//        }
//        if (protocolConfig.getAsync() != null) {
//            protocolConfigBean.setAsync(protocolConfig.getAsync());
//        }
//        config.setqueuesize
//        config.setaccepts
//        config.setdispatcher
//        config.setserver
//        config.setclient
//        if (protocolConfig.getDefaultConfig() != null) {
//            protocolConfigBean.setDefault(protocolConfig.getDefaultConfig());
//        }
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
//        if (!StringUtils.isEmpty(basicServiceConfig.getExport())) {
//            configBean.setExport(basicServiceConfig.getExport());
//        } else {
//            // 未设置export，使用ProtocolConfigBeanName : port暴露
//            if (StringUtils.isEmpty(basicServiceConfig.getExportPort())) {
//                throw new RuntimeException("need service export port...");
//            }
//            configBean.setExport(ConfConstants.PROTOCOL_CONFIG_BEAN_NAME + ":" + basicServiceConfig.getExportPort());
//        }
//
//        if (!StringUtils.isEmpty(basicServiceConfig.getExtConfigId())) {
//            ExtConfig extConfig = new ExtConfig();
//            extConfig.setId(basicServiceConfig.getExtConfigId());
//            configBean.setExtConfig(extConfig);
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getProxy())) {
//            configBean.setProxy(basicServiceConfig.getProxy());
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getGroup())) {
//            configBean.setGroup(basicServiceConfig.getGroup());
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getVersion())) {
//            configBean.setVersion(basicServiceConfig.getVersion());
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getThrowException())) {
//            configBean.setThrowException(basicServiceConfig.getThrowException());
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getApplication())) {
//            configBean.setApplication(basicServiceConfig.getApplication());
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getShareChannel())) {
//            configBean.setShareChannel(basicServiceConfig.getShareChannel());
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getRegistry())) {
//            // 追加内部的注册配置bean
//            configBean.setRegistry(ConfConstants.REGISTRY_CONFIG_BEAN_NAME + "," + basicServiceConfig.getRegistry());
//        } else {
//            configBean.setRegistry(ConfConstants.REGISTRY_CONFIG_BEAN_NAME);
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getAccessLog())) {
//            configBean.setAccessLog(basicServiceConfig.getAccessLog());
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getUsegz())) {
//            configBean.setUsegz(basicServiceConfig.getUsegz());
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getMingzSize())) {
//            configBean.setMingzSize(basicServiceConfig.getMingzSize());
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getCodec())) {
//            configBean.setCodec(basicServiceConfig.getCodec());
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getFilter())) {
//            configBean.setFilter(basicServiceConfig.getFilter());
//        }
//        if (!StringUtils.isEmpty(basicServiceConfig.getModule())) {
//            configBean.setModule(basicServiceConfig.getModule());
//        }
//        if (basicServiceConfig.getActives() != null) {
//            configBean.setActives(basicServiceConfig.getActives());
//        }
//        if (basicServiceConfig.getRegister() != null) {
//            configBean.setRegister(basicServiceConfig.getRegister());
//        }
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
//        configBean.setProtocol(ConfConstants.PROTOCOL_CONFIG_BEAN_NAME);
//        if (!StringUtils.isEmpty(basicRefererConfig.getGroup())) {
//            configBean.setGroup(basicRefererConfig.getGroup());
//        }
//        if (!StringUtils.isEmpty(basicRefererConfig.getModule())) {
//            configBean.setModule(basicRefererConfig.getModule());
//        }
//        if (!StringUtils.isEmpty(basicRefererConfig.getApplication())) {
//            configBean.setApplication(basicRefererConfig.getApplication());
//        }
//        if (!StringUtils.isEmpty(basicRefererConfig.getRegistry())) {
//            // 追加内部的注册配置bean
//            configBean.setRegistry(ConfConstants.REGISTRY_CONFIG_BEAN_NAME + "," + basicRefererConfig.getRegistry());
//        } else {
//            configBean.setRegistry(ConfConstants.REGISTRY_CONFIG_BEAN_NAME);
//        }
//        if (!StringUtils.isEmpty(basicRefererConfig.getCheck())) {
//            configBean.setCheck(basicRefererConfig.getCheck());
//        }
//        if (basicRefererConfig.getAccessLog() != null) {
//            configBean.setAccessLog(basicRefererConfig.getAccessLog());
//        }
//        if (basicRefererConfig.getRetries() != null) {
//            configBean.setRetries(basicRefererConfig.getRetries());
//        }
//        if (basicRefererConfig.getThrowException() != null) {
//            configBean.setThrowException(basicRefererConfig.getThrowException());
//        }
//        if (!StringUtils.isEmpty(basicRefererConfig.getId())) {
//            configBean.setId(basicRefererConfig.getId());
//        }
//        if (!StringUtils.isEmpty(basicRefererConfig.getVersion())) {
//            configBean.setVersion(basicRefererConfig.getVersion());
//        }
//        if (basicRefererConfig.getShareChannel() != null) {
//            configBean.setShareChannel(basicRefererConfig.getShareChannel());
//        }
//        if (basicRefererConfig.getRequestTimeout() != null) {
//            configBean.setRequestTimeout(basicRefererConfig.getRequestTimeout());
//        }
//        if (!StringUtils.isEmpty(basicRefererConfig.getFilter())) {
//            configBean.setFilter(basicRefererConfig.getFilter());
//        }
//        if (!StringUtils.isEmpty(basicRefererConfig.getExtConfigId())) {
//            ExtConfig extConfig = new ExtConfig();
//            extConfig.setId(basicRefererConfig.getExtConfigId());
//            configBean.setExtConfig(extConfig);
//        }
//        if (basicRefererConfig.getActives() != null) {
//            configBean.setActives(basicRefererConfig.getActives());
//        }
//        if (basicRefererConfig.getAsync() != null) {
//            configBean.setAsync(basicRefererConfig.getAsync());
//        }
//        if (!StringUtils.isEmpty(basicRefererConfig.getCodec())) {
//            configBean.setCodec(basicRefererConfig.getCodec());
//        }
//        if (basicRefererConfig.getUsegz() != null) {
//            configBean.setUsegz(basicRefererConfig.getUsegz());
//        }
//        if (basicRefererConfig.getMingzSize() != null) {
//            configBean.setMingzSize(basicRefererConfig.getMingzSize());
//        }
//        if (!StringUtils.isEmpty(basicRefererConfig.getProxy())) {
//            configBean.setProxy(basicRefererConfig.getProxy());
//        }
//        if (!StringUtils.isEmpty(basicRefererConfig.getMock())) {
//            configBean.setMock(basicRefererConfig.getMock());
//        }
        return configBean;
    }
}
