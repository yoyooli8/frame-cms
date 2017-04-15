package com.wxy.frame.cms.domain.beans;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description: com.wxy.frame.cms.domain.beans
 * @date 2017/4/6.
 * Created by 石头 on 2017/4/6.
 */
@Table(name = "cms_domain")
@Entity
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;        //主键ID
    @Column(name = "cms_name")
    private String name;
    @Column(name = "cms_desc")
    private String desc;
    @Column(name = "createTime")
    private Date createTime;   //创建时间
    @Column(name = "ccreateId")
    private Integer createId;  //创建人
    @Column(name = "cupdateTime")
    private Date updateTime;   //修改时间
    @Column(name = "updateId")
    private Integer updateId;  //修改人
    @Column(name = "status")
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
