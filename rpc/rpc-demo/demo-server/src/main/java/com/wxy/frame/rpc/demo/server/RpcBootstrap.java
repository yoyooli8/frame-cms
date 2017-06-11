package com.wxy.frame.rpc.demo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yoyoo on 17-6-11.
 */
public class RpcBootstrap {
    private static Logger logger = LoggerFactory.getLogger(RpcBootstrap.class);
    public static void main(String[] args) {
        logger.debug("start server");
        new ClassPathXmlApplicationContext("spring.xml");
    }
}
