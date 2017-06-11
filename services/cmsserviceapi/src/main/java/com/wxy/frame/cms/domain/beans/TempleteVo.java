package com.wxy.frame.cms.domain.beans;

import java.util.Date;
import java.util.List;

/**
 * Created by yoyoo on 17-5-7.
 */
public class TempleteVo {
    private Integer id;        //主键ID
    private Integer domainId; // 域ID
    private String name;      // 名称
    private String desc;      // 描述
    private Date createTime;   //创建时间
    private Integer createId;  //创建人
    private Date updateTime;   //修改时间
    private Integer updateId;  //修改人
    private Integer status;    //数据有效性1:有效,0:无效
    private List<TempletePropVo> templetePropVos; //模板下的属性

    public List<TempletePropVo> getTempletePropVos() {
        return templetePropVos;
    }

    public void setTempletePropVos(List<TempletePropVo> templetePropVos) {
        this.templetePropVos = templetePropVos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
