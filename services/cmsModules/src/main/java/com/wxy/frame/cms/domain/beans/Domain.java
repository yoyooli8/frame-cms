package com.wxy.frame.cms.domain.beans;

import com.wxy.frame.cms.commons.beans.BaseBean;

import javax.persistence.Table;

/**
 * @Description: com.wxy.frame.cms.domain.beans
 * @date 2017/4/6.
 * Created by 石头 on 2017/4/6.
 */
@Table(name = "cms_domain")
public class Domain extends BaseBean {
    private String name;
    private String desc;

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
