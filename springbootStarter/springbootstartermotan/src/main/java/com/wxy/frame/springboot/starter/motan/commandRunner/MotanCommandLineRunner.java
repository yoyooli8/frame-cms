package com.wxy.frame.springboot.starter.motan.commandRunner;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;
import com.wxy.frame.springboot.starter.motan.properties.RegistryConfigProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;

/**
 * @Description: com.wxy.frame.springboot.starter.motan.commandRunner
 * @date 2017/4/14.
 * Created by 石头 on 2017/4/14.
 */
@Configuration
@Order(Ordered.LOWEST_PRECEDENCE)
public class MotanCommandLineRunner implements CommandLineRunner {
    /** Registry Config */
    @Resource
    private RegistryConfigProperties registryConfig;
    @Override
    public void run(String... args) throws Exception {
        if (!registryConfig.getRegProtocol().toLowerCase().equals("local")) {
            // 开启注册中心
            MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        }
    }
}
