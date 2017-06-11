package com.wxy.frame.rpc.demo.server;

import com.wxy.frame.rpc.demo.api.HelloService;
import com.wxy.frame.rpc.demo.api.Person;
import com.wxy.frame.rpc.server.RpcService;

/**
 * Created by yoyoo on 17-6-11.
 */
@RpcService(value = HelloService.class, version = "sample.hello2")
public class HelloServiceImpl2 implements HelloService {
    @Override
    public String hello(String name) {
        return "你好! " + name;
    }

    @Override
    public String hello(Person person) {
        return "你好! " + person.getFirstName() + " " + person.getLastName();
    }
}
