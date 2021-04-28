package com.luna.csi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 职位表(Job)实体类
 *
 * @author luna
 * @since 2021-04-28 15:46:12
 */
public class Job implements Serializable {
    private static final long serialVersionUID = -63356000406843001L;
    /** 职位编号 */
    private Long              id;
    /** 职位名称 */
    private String            jobName;
    private String            jobRemark;
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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobRemark() {
        return jobRemark;
    }

    public void setJobRemark(String jobRemark) {
        this.jobRemark = jobRemark;
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
