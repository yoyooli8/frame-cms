package com.wxy.frame.rpc.demo.client;

import com.wxy.frame.rpc.client.RpcProxy;
import com.wxy.frame.rpc.demo.api.HelloService;
import com.wxy.frame.rpc.demo.api.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yoyoo on 17-6-11.
 */
public class HelloClient2 {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        RpcProxy rpcProxy = context.getBean(RpcProxy.class);

        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloService.hello(new Person("Yong", "Huang"));
        System.out.println(result);

        System.exit(0);
    }
}
