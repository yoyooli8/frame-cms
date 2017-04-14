package com.wxy.frame.cms.domain.service.impl;

import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import com.wxy.frame.cms.domain.beans.Domain;
import com.wxy.frame.cms.domain.dao.DomainDaoI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: 资源域service
 * @date 2017/4/7.
 * Created by 石头 on 2017/4/7.
 */
@MotanService
public class DomainService implements com.wxy.frame.cms.domain.service.DomainServiceI {
    @Autowired
    private DomainDaoI domainDao;
    @Override
    public Integer saveDomain(Domain domain){
        return domainDao.saveDomain(domain);
    }
    @Override
    public Integer updateDomain(Domain domain){
        return domainDao.updateDomain(domain);
    }
    @Override
    public List<Domain> getAllDomain(){
        return domainDao.getAllDomain();
    }
    @Override
    public Domain getDomainById(Integer id){
        return domainDao.getDomainById(id);
    }
    @Override
    public Integer deleteDomain(Integer id){
        return domainDao.deleteDomain(id);
    }
}
