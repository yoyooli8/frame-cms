package com.wxy.frame.cms.templete.services.beans;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description: 模板
 * @date 2017/4/5.
 * Created by 石头 on 2017/4/5.
 */
@Table(name = "cms_templete")
@Entity
public class Templete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;        //主键ID
    private Integer domainId; // 域ID
    private String name;      // 名称
    private String desc;      // 描述
    private Date createTime;   //创建时间
    private Integer createId;  //创建人
    private Date updateTime;   //修改时间
    private Integer updateId;  //修改人
    private Integer status;    //数据有效性1:有效,0:无效

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
