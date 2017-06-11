package com.wxy.frame.rpc.registry.api;

/**
 * 服务注册接口
 * Created by yoyoo on 17-6-10.
 */
public interface ServiceRegistry {
    /**
     * 注册服务名称与服务地址
     *
     * @param serviceName    服务名称
     * @param serviceAddress 服务地址
     */
    void register(String serviceName, String serviceAddress);
}
