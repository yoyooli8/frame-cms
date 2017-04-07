package com.wxy.frame.cms.templete.services.beans;

import com.wxy.frame.cms.commons.beans.BaseBean;

import javax.persistence.Table;

/**
 * @Description: 模板
 * @date 2017/4/5.
 * Created by 石头 on 2017/4/5.
 */
@Table(name = "cms_templete")
public class Templete extends BaseBean {
    private Integer domainId; // 域ID
    private String name;      // 名称
    private String desc;      // 描述

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
