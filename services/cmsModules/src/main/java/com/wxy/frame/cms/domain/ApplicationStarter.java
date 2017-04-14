package com.wxy.frame.cms.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Description: com.wxy.frame.cms.domain
 * @date 2017/4/7.
 * Created by 石头 on 2017/4/7.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages="com.wxy.frame.cms.domain.repository")
public class ApplicationStarter {
    public static void main(String[] args){
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
