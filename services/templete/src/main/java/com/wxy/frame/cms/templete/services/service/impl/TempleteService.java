package com.wxy.frame.cms.templete.services.service.impl;

import com.wxy.frame.cms.templete.services.beans.Templete;
import com.wxy.frame.cms.templete.services.dao.TempleteDaoI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: 模板service
 * @date 2017/4/5.
 * Created by 石头 on 2017/4/5.
 */
public class TempleteService implements com.wxy.frame.cms.templete.services.service.TempleteServiceI {
    @Autowired
    private TempleteDaoI templeteDao;
    public Integer saveTemplete(Templete templete){
        return templeteDao.saveTemplete(templete);
    }
    public List<Templete> getTempleteByDomainId(Integer domainId){
        return templeteDao.getTempleteByDomainId(domainId);
    }
    public Templete getTempleteById(Integer id){
        return templeteDao.getTempleteById(id);
    }
    public Integer updateTempleteNameAndDesc(Templete templete){
        return templeteDao.updateTempleteNameAndDesc(templete);
    }
    public Integer deleteTemplete(Integer id){
        return templeteDao.deleteTemplete(id);
    }
}
