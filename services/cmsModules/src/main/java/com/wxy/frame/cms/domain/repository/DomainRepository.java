package com.wxy.frame.cms.domain.repository;

import com.wxy.frame.cms.domain.beans.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description: 资源域操作
 * @date 2017/4/6.
 * Created by 石头 on 2017/4/6.
 */
public interface DomainRepository extends JpaRepository<Domain,Integer> {
    Domain findDomainById(Integer id);

    @Query(value = "from Domain d where d.status = 1")
    List<Domain> getAllDomain();

    @Query(value = "update Domain d set d.name=?1,d.desc=?2 where d.id=?3")
    @Modifying
    Integer updateDomainNameAndDesc(String name,String desc,Integer id);

    @Query(value = "update Domain d set d.status=0 where d.id=?1")
    @Modifying
    Integer deleteDomain(Integer id);
}
