package com.wxy.frame.cms.domain.service;

import com.wxy.frame.cms.domain.beans.DomainVo;

import java.util.List;

/**
 * @Description: 资源域service接口
 * @date 2017/4/7.
 * Created by 石头 on 2017/4/7.
 */
public interface DomainServiceI {
    Integer saveDomain(DomainVo domain);

    Integer updateDomain(DomainVo domain);

    List<DomainVo> getAllDomain();

    DomainVo getDomainById(Integer id);

    Integer deleteDomain(Integer id);
}
