package com.wxy.frame.cms.domain.dao;

import com.wxy.frame.cms.domain.beans.Domain;

import java.util.List;

/**
 * @Description: com.wxy.frame.cms.domain.dao.impl
 * @date 2017/4/6.
 * Created by 石头 on 2017/4/6.
 */
public interface DomainDaoI {
    Integer saveDomain(Domain domain);

    Integer updateDomain(Domain domain);

    List<Domain> getAllDomain();

    Domain getDomainById(Integer id);

    Integer deleteDomain(Integer id);
}
