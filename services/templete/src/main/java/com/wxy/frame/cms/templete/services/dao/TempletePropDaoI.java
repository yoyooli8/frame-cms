package com.wxy.frame.cms.templete.services.dao;

import com.wxy.frame.cms.templete.services.beans.TempleteProp;

import java.util.List;

/**
 * Created by yoyoo on 17-5-7.
 */
public interface TempletePropDaoI {
    Integer saveTempleteProp(TempleteProp templeteProp);
    Integer updateTempleteProp(TempleteProp templeteProp);
    List<TempleteProp> getTempletePropByTempleteId(Integer templeteId);
    TempleteProp getTempletePropById(Integer id);
    Integer deleteTempleteProp(Integer id);
}
