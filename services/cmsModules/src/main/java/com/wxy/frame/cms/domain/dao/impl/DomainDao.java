package com.wxy.frame.cms.domain.dao.impl;

import com.wxy.frame.cms.commons.utils.IntegerUtil;
import com.wxy.frame.cms.domain.beans.Domain;
import com.wxy.frame.cms.domain.dao.DomainDaoI;
import com.wxy.frame.cms.domain.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: com.wxy.frame.cms.domain.dao.impl
 * @date 2017/4/6.
 * Created by 石头 on 2017/4/6.
 */
public class DomainDao implements DomainDaoI {
    @Autowired
    private DomainRepository domainRepository;

    public Integer saveDomain(Domain domain){
        Domain newDomain = domainRepository.save(domain);
        return newDomain.getId();
    }

    public Integer updateDomain(Domain domain){
        if (domain == null || domain.getId() == null || domain.getId().intValue() == IntegerUtil.ZERO.intValue()) {
            return IntegerUtil.ZERO;
        }

        return domainRepository.updateDomainNameAndDesc(domain.getName(),domain.getDesc(),domain.getId());
    }
    public List<Domain> getAllDomain(){
        return domainRepository.getAllDomain();
    }
    public Domain getDomainById(Integer id){
        return domainRepository.findDomainById(id);
    }
    public Integer deleteDomain(Integer id){
        return domainRepository.deleteDomain(id);
    }
}
