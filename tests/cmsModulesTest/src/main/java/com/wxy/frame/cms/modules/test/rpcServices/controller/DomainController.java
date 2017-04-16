package com.wxy.frame.cms.modules.test.rpcServices.controller;

import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import com.wxy.frame.cms.domain.beans.DomainVo;
import com.wxy.frame.cms.domain.service.DomainServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yoyoo on 17-4-15.
 */
@RestController
public class DomainController {
    private Logger log = LoggerFactory.getLogger(DomainController.class);
    @MotanReferer
    private DomainServiceI domainService;

    @RequestMapping("/getDomain/{domainId}")
    public DomainVo getDomain(@PathVariable Integer domainId){
        return domainService.getDomainById(domainId);
    }

    @RequestMapping("/getAllDomain")
    public List<DomainVo> getDomain(){
        return domainService.getAllDomain();
    }

    @RequestMapping(value = "/addDomain",method = RequestMethod.POST,consumes = "application/json")
    public Integer saveDomain (@RequestBody DomainVo domainVo) {
        log.info("添加资源域开始.....");
        return domainService.saveDomain(domainVo);
    }

}
