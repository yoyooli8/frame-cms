package com.wxy.frame.cms.templete.services.beans;

import com.wxy.frame.cms.commons.beans.BaseBean;

import javax.persistence.Table;

/**
 * @Description: 模板属性
 * @date 2017/4/5.
 * Created by 石头 on 2017/4/5.
 */
@Table(name = "cms_templeteProp")
public class TempleteProp extends BaseBean {
    private Integer templetId;    //模板ID
    private String  name;         //属性
    private String  label;        //属性名称
    private Integer propType;     //属性类型
    private String  defVal;       //默认值
    private Integer isNeed;       //是否必须
    private String  validateName; //验证名称
    private Integer propOrder;    //属性顺序
    private Integer domainId;     //域ID

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public Integer getTempletId() {
        return templetId;
    }

    public void setTempletId(Integer templetId) {
        this.templetId = templetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getPropType() {
        return propType;
    }

    public void setPropType(Integer propType) {
        this.propType = propType;
    }

    public String getDefVal() {
        return defVal;
    }

    public void setDefVal(String defVal) {
        this.defVal = defVal;
    }

    public Integer getIsNeed() {
        return isNeed;
    }

    public void setIsNeed(Integer isNeed) {
        this.isNeed = isNeed;
    }

    public String getValidateName() {
        return validateName;
    }

    public void setValidateName(String validateName) {
        this.validateName = validateName;
    }

    public Integer getPropOrder() {
        return propOrder;
    }

    public void setPropOrder(Integer propOrder) {
        this.propOrder = propOrder;
    }
}
