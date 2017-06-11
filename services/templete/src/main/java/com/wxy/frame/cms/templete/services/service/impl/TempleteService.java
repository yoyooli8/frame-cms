package com.wxy.frame.cms.templete.services.service.impl;

import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import com.wxy.frame.cms.commons.utils.BeanUtil;
import com.wxy.frame.cms.domain.beans.DomainVo;
import com.wxy.frame.cms.domain.beans.TempletePropVo;
import com.wxy.frame.cms.domain.beans.TempleteVo;
import com.wxy.frame.cms.domain.service.TempleteServiceI;
import com.wxy.frame.cms.templete.services.beans.Templete;
import com.wxy.frame.cms.templete.services.beans.TempleteProp;
import com.wxy.frame.cms.templete.services.dao.TempleteDaoI;
import com.wxy.frame.cms.templete.services.dao.TempletePropDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 模板service
 * @date 2017/4/5.
 * Created by 石头 on 2017/4/5.
 */
@MotanService
@Service
public class TempleteService implements TempleteServiceI {
    @Autowired
    private TempleteDaoI templeteDao;
    @Autowired
    private TempletePropDaoI templetePropDao;

    public Integer saveTemplete(TempleteVo templeteVo, List<TempletePropVo> templeteProps){
        Templete templete = new Templete();
        BeanUtil.copyProperties(templeteVo,templete);
        Integer templeteId = templeteDao.saveTemplete(templete);
        if(templeteId!=null && templeteId.intValue()>0 && templeteProps!=null && templeteProps.size()>0){
            for (TempletePropVo propVo :templeteProps){
                TempleteProp prop = new TempleteProp();
                BeanUtil.copyProperties(propVo,prop);

                prop.setTempletId(templeteId);
                prop.setCreateId(templete.getCreateId());
                prop.setCreateTime(templete.getCreateTime());
                prop.setUpdateId(templete.getUpdateId());
                prop.setUpdateTime(templete.getUpdateTime());

                templetePropDao.saveTempleteProp(prop);
            }
        }

        return templeteId;
    }
    public List<TempleteVo> getTempleteByDomainId(Integer domainId){
        List<Templete> templetes = templeteDao.getTempleteByDomainId(domainId);

        List<TempleteVo> result = BeanUtil.copyProperties(templetes,TempleteVo.class);
        return result;
    }
    public TempleteVo getTempleteById(Integer id){
        Templete templete = templeteDao.getTempleteById(id);

        TempleteVo result = new TempleteVo();
        BeanUtil.copyProperties(templete,result);

        List<TempleteProp> tempLeteProps = templetePropDao.getTempletePropByTempleteId(id);
        List<TempletePropVo> templetePropVos = BeanUtil.copyProperties(tempLeteProps,TempletePropVo.class);
        result.setTempletePropVos(templetePropVos);

        return result;
    }
    public Integer updateTempleteNameAndDesc(TempleteVo templeteVo){
        Templete templete = new Templete();
        BeanUtil.copyProperties(templeteVo,templete);

        int rtn = 0;
        if (templete.getId()!=null && templete.getId().intValue()>0 &&
                (templete.getName()!=null || templete.getDesc()!=null)){
            rtn = templeteDao.updateTempleteNameAndDesc(templete);
        }


        List<TempletePropVo> tempLeteProps = templeteVo.getTempletePropVos();
        if (tempLeteProps!=null && tempLeteProps.size()>0){
            for (TempletePropVo propVo: tempLeteProps){
                TempleteProp prop = new TempleteProp();
                BeanUtil.copyProperties(propVo,prop);

                prop.setTempletId(templete.getId());
                prop.setUpdateId(templete.getUpdateId());
                prop.setUpdateTime(templete.getUpdateTime());

                rtn = rtn + templetePropDao.updateTempleteProp(prop);
            }
        }

        return rtn;
    }

    public Integer deleteTempleteProp(Integer id){
        return templetePropDao.deleteTempleteProp(id);
    }

    public Integer deleteTemplete(Integer id){
        return templeteDao.deleteTemplete(id);
    }
}
