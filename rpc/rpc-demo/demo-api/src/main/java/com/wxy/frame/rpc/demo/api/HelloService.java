package com.wxy.frame.rpc.demo.api;

/**
 * Created by yoyoo on 17-6-11.
 */
public interface HelloService {
    String hello(String name);

    String hello(Person person);
}
