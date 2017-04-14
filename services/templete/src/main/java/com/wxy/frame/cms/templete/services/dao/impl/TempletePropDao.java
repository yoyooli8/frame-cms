package com.wxy.frame.cms.templete.services.dao.impl;

import com.wxy.frame.cms.commons.utils.IntegerUtil;
import com.wxy.frame.cms.templete.services.beans.TempleteProp;
import com.wxy.frame.cms.templete.services.repository.TempletePropRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description: com.wxy.frame.cms.templete.services.dao.impl
 * @date 2017/4/10.
 * Created by 石头 on 2017/4/10.
 */
public class TempletePropDao {
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

        return IntegerUtil.ZERO;
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
