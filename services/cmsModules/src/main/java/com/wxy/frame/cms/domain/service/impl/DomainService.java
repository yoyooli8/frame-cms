package com.wxy.frame.cms.domain.service.impl;

import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import com.wxy.frame.cms.commons.utils.BeanUtil;
import com.wxy.frame.cms.domain.beans.Domain;
import com.wxy.frame.cms.domain.beans.DomainVo;
import com.wxy.frame.cms.domain.dao.DomainDaoI;
import com.wxy.frame.cms.domain.service.DomainServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 资源域service
 * @date 2017/4/7.
 * Created by 石头 on 2017/4/7.
 */
@MotanService
@Service
public class DomainService implements DomainServiceI {
    @Autowired
    private DomainDaoI domainDao;
    @Override
    public Integer saveDomain(DomainVo domainVo){
        Domain domain = new Domain();
        BeanUtil.copyProperties(domainVo,domain);

        return domainDao.saveDomain(domain);
    }
    @Override
    public Integer updateDomain(DomainVo domainVo){
        Domain domain = new Domain();
        BeanUtil.copyProperties(domainVo,domain);

        return domainDao.updateDomain(domain);
    }
    @Override
    public List<DomainVo> getAllDomain(){
        List<Domain> datas = domainDao.getAllDomain();

        List<DomainVo> result = BeanUtil.copyProperties(datas,DomainVo.class);

        return result;
    }
    @Override
    public DomainVo getDomainById(Integer id){
        Domain data = domainDao.getDomainById(id);
        DomainVo result = new DomainVo();
        BeanUtil.copyProperties(data,result);
        return result;
    }
    @Override
    public Integer deleteDomain(Integer id){
        return domainDao.deleteDomain(id);
    }
}
