package com.wxy.frame.springboot.starter.motan.support;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

/**
 * @Description: com.wxy.frame.springboot.starter.motan.support
 * @date 2017/4/14.
 * Created by 石头 on 2017/4/14.
 */
public class BasicServiceConfigCondition implements Condition{
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment env = conditionContext.getEnvironment();

        return (!StringUtils.isEmpty(env.getProperty("spring.data.motan.basicservice.exportPort"))
                || !StringUtils.isEmpty(env.getProperty("spring.data.motan.basicservice.export")));
    }
}
