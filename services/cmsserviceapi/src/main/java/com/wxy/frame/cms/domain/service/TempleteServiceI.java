package com.wxy.frame.cms.domain.service;

import com.wxy.frame.cms.domain.beans.TempletePropVo;
import com.wxy.frame.cms.domain.beans.TempleteVo;

import java.util.List;

/**
 * @Description: 模板service接口
 * @date 2017/4/5.
 * Created by 石头 on 2017/4/5.
 */
public interface TempleteServiceI {
    Integer saveTemplete(TempleteVo templete, List<TempletePropVo> templeteProps);
    List<TempleteVo> getTempleteByDomainId(Integer domainId);
    TempleteVo getTempleteById(Integer id);
    Integer updateTempleteNameAndDesc(TempleteVo templete);
    Integer deleteTemplete(Integer id);
    Integer deleteTempleteProp(Integer id);
}
