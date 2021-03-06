package com.luna.csi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 文档信息表(Document)实体类
 *
 * @author luna
 * @since 2021-05-06 10:55:58
 */
public class Document implements Serializable {
    private static final long serialVersionUID = 203135385488207859L;
    /** 文档编号 */
    private Long              id;
    /** 创建人 */
    private Long              createBy;
    /** 文档标题 */
    private String            fileTitle;
    /** 文档描述 */
    private String            fileDescription;
    /** 文档地址 */
    private String            fileUrl;
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

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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

    @Override
    public String toString() {
        return "Document{" +
            "id=" + id +
            ", createBy=" + createBy +
            ", fileTitle='" + fileTitle + '\'' +
            ", fileDescription='" + fileDescription + '\'' +
            ", fileUrl='" + fileUrl + '\'' +
            ", createTime=" + createTime +
            ", modifiedTime=" + modifiedTime +
            ", version=" + version +
            '}';
    }
}
