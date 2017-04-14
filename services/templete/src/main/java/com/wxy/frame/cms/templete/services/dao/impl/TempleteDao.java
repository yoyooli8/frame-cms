package com.wxy.frame.cms.templete.services.dao.impl;

import com.wxy.frame.cms.commons.utils.IntegerUtil;
import com.wxy.frame.cms.templete.services.beans.Templete;
import com.wxy.frame.cms.templete.services.repository.TempleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: 模板dao
 * @date 2017/4/5.
 * Created by 石头 on 2017/4/5.
 */
@Component
public class TempleteDao implements com.wxy.frame.cms.templete.services.dao.TempleteDaoI {
    @Autowired
    private TempleteRepository templeteRepository;
    public Integer saveTemplete(Templete templete){
        Templete newTemplete = templeteRepository.save(templete);
        return newTemplete.getId();
    }
    public List<Templete> getTempleteByDomainId(Integer domainId){
        return templeteRepository.findTempleteByDomainId(domainId);
    }
    public Templete getTempleteById(Integer id){
        return templeteRepository.findTempleteById(id);
    }
    public Integer updateTempleteNameAndDesc(Templete templete){
        Integer tplId = templete.getId();
        if(templete == null || tplId == null || tplId.intValue() == IntegerUtil.ZERO.intValue()){
            return IntegerUtil.ZERO;
        }

        return templeteRepository.updateTempleteByIdAndTempleteId(templete.getName(),templete.getDesc(),templete.getId());
    }

    public Integer deleteTemplete(Integer id){
        return templeteRepository.updateTempleteByIdAndTempleteId(id);
    }
}
