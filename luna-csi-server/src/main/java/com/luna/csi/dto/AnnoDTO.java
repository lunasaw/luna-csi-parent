package com.luna.csi.dto;

import java.util.Date;

/**
 * @author luna@mac
 * 2021年05月06日 15:30
 */
public class AnnoDTO {

    /** 公告编号 */
    private Long   id;
    /** 创建人 */
    private String createBy;
    /** 公告标题 */
    private String annoTitle;
    /** 公告内容 */
    private String annoContent;
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

    public String getAnnoTitle() {
        return annoTitle;
    }

    public void setAnnoTitle(String annoTitle) {
        this.annoTitle = annoTitle;
    }

    public String getAnnoContent() {
        return annoContent;
    }

    public void setAnnoContent(String annoContent) {
        this.annoContent = annoContent;
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
}
