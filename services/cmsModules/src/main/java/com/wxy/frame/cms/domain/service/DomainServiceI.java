package com.wxy.frame.cms.domain.service;

import com.wxy.frame.cms.domain.beans.Domain;

import java.util.List;

/**
 * @Description: 资源域service接口
 * @date 2017/4/7.
 * Created by 石头 on 2017/4/7.
 */
public interface DomainServiceI {
    Integer saveDomain(Domain domain);

    Integer updateDomain(Domain domain);

    List<Domain> getAllDomain();

    Domain getDomainById(Integer id);

    Integer deleteDomain(Integer id);
}
