package com.wxy.frame.cms.templete.services.repository;

import com.wxy.frame.cms.templete.services.beans.Templete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description: com.wxy.frame.cms.templete.services.repository
 * @date 2017/4/5.
 * Created by 石头 on 2017/4/5.
 */
public interface TempleteRepository extends JpaRepository<Templete,Integer>{
    Templete findTempleteById(Integer id);

    List<Templete> findTempleteByDomainId(Integer domainId);

    @Query(value = "update Templete t set t.name=?1,t.desc=?2 where t.id=?3")
    @Modifying
    Integer updateTempleteByIdAndTempleteId(String name,String desc,Integer id);

    @Query(value = "update Templete t set t.status=0 where t.id=?1")
    @Modifying
    Integer updateTempleteByIdAndTempleteId(Integer id);
}
