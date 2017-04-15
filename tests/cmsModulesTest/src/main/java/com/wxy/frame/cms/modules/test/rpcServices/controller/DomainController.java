package com.wxy.frame.cms.modules.test.rpcServices.controller;

import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import com.wxy.frame.cms.domain.beans.DomainVo;
import com.wxy.frame.cms.domain.service.DomainServiceI;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yoyoo on 17-4-15.
 */
@RestController
public class DomainController {
    @MotanReferer
    private DomainServiceI domainService;

    @RequestMapping("/save/{domainId}")
    public DomainVo testSaveDomain(@PathVariable Integer domainId){
        return domainService.getDomainById(domainId);
    }
}
