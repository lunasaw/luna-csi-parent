package com.luna.csi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 部门表(Dept)实体类
 *
 * @author luna
 * @since 2021-04-28 15:46:45
 */
public class Dept implements Serializable {
    private static final long serialVersionUID = -13453261201474616L;
    /** 部门编号 */
    private Long              id;
    /** 部门名称 */
    private String            deptName;
    /** 备注 */
    private String            deptRemark;
    /** 创建时间 */
    private Date              createTime;
    /** 修改时间 */
    private Date              modifiedTime;
    /** 锁 */
    private Object            version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptRemark() {
        return deptRemark;
    }

    public void setDeptRemark(String deptRemark) {
        this.deptRemark = deptRemark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Object getVersion() {
        return version;
    }

    public void setVersion(Object version) {
        this.version = version;
    }

}
