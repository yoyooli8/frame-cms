package com.wxy.frame.cms.templete.services.service;

import com.wxy.frame.cms.templete.services.beans.Templete;

import java.util.List;

/**
 * @Description: 模板service接口
 * @date 2017/4/5.
 * Created by 石头 on 2017/4/5.
 */
public interface TempleteServiceI {
    Integer saveTemplete(Templete templete);
    List<Templete> getTempleteByDomainId(Integer domainId);
    Templete getTempleteById(Integer id);
    Integer updateTempleteNameAndDesc(Templete templete);
    Integer deleteTemplete(Integer id);
}
