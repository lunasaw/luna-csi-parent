package com.luna.csi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 文档信息表(Document)实体类
 *
 * @author luna
 * @since 2021-04-30 11:48:43
 */
public class Document implements Serializable {
    private static final long serialVersionUID = -98796964148867667L;
    /** 文档编号 */
    private Long              id;
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

}
