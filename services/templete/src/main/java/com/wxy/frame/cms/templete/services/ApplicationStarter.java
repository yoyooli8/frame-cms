package com.wxy.frame.cms.templete.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by yoyoo on 17-5-28.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages="com.wxy.frame.cms.templete.services.repository")
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
