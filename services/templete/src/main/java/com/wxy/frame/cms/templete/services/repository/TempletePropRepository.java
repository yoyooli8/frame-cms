package com.wxy.frame.cms.templete.services.repository;

import com.wxy.frame.cms.templete.services.beans.TempleteProp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description: com.wxy.frame.cms.templete.services.repository
 * @date 2017/4/10.
 * Created by 石头 on 2017/4/10.
 */
public interface TempletePropRepository extends JpaRepository<TempleteProp,Integer> {
    TempleteProp findTempletePropById(Integer id);
    List<TempleteProp> findTempletePropByTempletId(Integer templetId);
    @Query(value = "update TempleteProp t set t.name=?2,t.label=?3,t.propType=?4,t.defVal=?5,t.isNeed=?6,t.validateName=?7,propOrder=?8 where t.id=?1")
    @Modifying
    Integer updateTemplatePropsById(Integer id,String name,String label,Integer propType,String  defVal,Integer isNeed,String  validateName,Integer propOrder);
    @Query(value = "update TempleteProp t set t.status=?2 where t.id=?1")
    @Modifying
    Integer updateTempletePropByIdAndTempletePropId(Integer id,Integer status);
}
