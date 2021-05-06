package com.luna.csi.dto;

import java.util.Date;

/**
 * @author luna@mac
 * 2021年05月06日 11:00
 */
public class DocumentDTO {

    /** 文档编号 */
    private Long   id;
    /** 创建人 */
    private String createBy;
    /** 文档标题 */
    private String fileTitle;
    /** 文档描述 */
    private String fileDescription;
    /** 文档地址 */
    private String fileUrl;
    /** 创建时间 */
    private String createTime;
    /** 修改时间 */
    private String modifiedTime;
    /** 锁 */
    private Object version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
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
        return "DocumentDTO{" +
            "id=" + id +
            ", createBy='" + createBy + '\'' +
            ", fileTitle='" + fileTitle + '\'' +
            ", fileDescription='" + fileDescription + '\'' +
            ", fileUrl='" + fileUrl + '\'' +
            ", createTime='" + createTime + '\'' +
            ", modifiedTime='" + modifiedTime + '\'' +
            ", version=" + version +
            '}';
    }
}
