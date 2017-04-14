package com.wxy.frame.cms.templete.services.beans;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description: 模板属性
 * @date 2017/4/5.
 * Created by 石头 on 2017/4/5.
 */
@Table(name = "cms_templeteProp")
@Entity
public class TempleteProp{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;        //主键ID
    private Integer templetId;    //模板ID
    private String  name;         //属性
    private String  label;        //属性名称
    private Integer propType;     //属性类型
    private String  defVal;       //默认值
    private Integer isNeed;       //是否必须
    private String  validateName; //验证名称
    private Integer propOrder;    //属性顺序
    private Integer domainId;     //域ID
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
