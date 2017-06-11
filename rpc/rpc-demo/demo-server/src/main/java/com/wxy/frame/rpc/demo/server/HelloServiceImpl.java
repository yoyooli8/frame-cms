package com.wxy.frame.rpc.demo.server;

import com.wxy.frame.rpc.demo.api.HelloService;
import com.wxy.frame.rpc.demo.api.Person;
import com.wxy.frame.rpc.server.RpcService;

/**
 * Created by yoyoo on 17-6-11.
 */
@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello! " + name;
    }
    @Override
    public String hello(Person person) {
        return "Hello! " + person.getFirstName() + " " + person.getLastName();
    }
}
