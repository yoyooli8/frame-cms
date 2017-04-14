package com.wxy.frame.cms.modules.test.rpcServices;

import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import com.wxy.frame.cms.domain.beans.Domain;
import com.wxy.frame.cms.domain.service.DomainServiceI;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: com.wxy.frame.cms.modules.test.rpcServices
 * @date 2017/4/14.
 * Created by 石头 on 2017/4/14.
 */
@SpringBootApplication
public class TestRpcServiceWithMotan {
    @MotanReferer
    private DomainServiceI domainService;

    @RequestMapping("/save")
    @ResponseBody
    public Integer testSaveDomain(@RequestBody Domain domain){
        return domainService.saveDomain(domain);
    }
}
