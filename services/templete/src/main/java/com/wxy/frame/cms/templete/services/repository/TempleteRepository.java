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

    @Query(value = "update Templete set name=?1,desc=?2 where id=?3")
    @Modifying
    Integer updateTempleteNameAndDesc(String name,String desc,Integer id);

    @Query(value = "update Templete set status=0 where id=?1")
    @Modifying
    Integer deleteTemplete(Integer id);
}
