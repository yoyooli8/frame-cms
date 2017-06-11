package com.wxy.frame.cms.templete.services.dao.impl;

import com.wxy.frame.cms.commons.utils.IntegerUtil;
import com.wxy.frame.cms.templete.services.beans.TempleteProp;
import com.wxy.frame.cms.templete.services.dao.TempletePropDaoI;
import com.wxy.frame.cms.templete.services.repository.TempletePropRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: com.wxy.frame.cms.templete.services.dao.impl
 * @date 2017/4/10.
 * Created by 石头 on 2017/4/10.
 */
public class TempletePropDao implements TempletePropDaoI {
    @Autowired
    private TempletePropRepository templetePropRepository;

    public Integer saveTempleteProp(TempleteProp templeteProp){
        TempleteProp newTempleteProp = templetePropRepository.save(templeteProp);

        return newTempleteProp.getId();
    }

    public Integer updateTempleteProp(TempleteProp templeteProp){
        Integer propId = templeteProp.getId();
        if(propId == null){
            return IntegerUtil.ZERO;
        }
        TempleteProp oldTempleteProp = templetePropRepository.findTempletePropById(propId);
        if(oldTempleteProp == null){
            return IntegerUtil.ZERO;
        }
        Integer id           = propId;
        String name          = templeteProp.getName()==null?oldTempleteProp.getName():templeteProp.getName();
        String label         = templeteProp.getLabel()==null?oldTempleteProp.getLabel():templeteProp.getLabel();
        Integer propType     = templeteProp.getPropType()==null?oldTempleteProp.getPropType():templeteProp.getPropType();
        String  defVal       = templeteProp.getDefVal()==null?oldTempleteProp.getDefVal():templeteProp.getDefVal();
        Integer isNeed       = templeteProp.getIsNeed()==null?oldTempleteProp.getIsNeed():templeteProp.getIsNeed();
        String  validateName = templeteProp.getValidateName()==null?oldTempleteProp.getValidateName():templeteProp.getValidateName();
        Integer propOrder    = templeteProp.getPropOrder()==null?oldTempleteProp.getPropOrder():templeteProp.getPropOrder();

        Integer upNum = templetePropRepository.updateTemplatePropsById(id,name,label,propType,defVal,isNeed,validateName,propOrder);
        return upNum;
    }

    public List<TempleteProp> getTempletePropByTempleteId(Integer templeteId){
        List<TempleteProp> props = templetePropRepository.findTempletePropByTempletId(templeteId);

        return props;
    }
    public TempleteProp getTempletePropById(Integer id){
        TempleteProp templeteProp = templetePropRepository.findTempletePropById(id);
        return templeteProp;
    }
    public Integer deleteTempleteProp(Integer id){
        return templetePropRepository.updateTempletePropByIdAndTempletePropId(id, IntegerUtil.ZERO);
    }

}
