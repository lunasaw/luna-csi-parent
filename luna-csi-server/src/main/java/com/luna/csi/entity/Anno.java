package com.luna.csi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 通知公告(Anno)实体类
 *
 * @author luna
 * @since 2021-04-30 11:42:35
 */
public class Anno implements Serializable {
    private static final long serialVersionUID = 705245872036029981L;
    /** 公告编号 */
    private Long              id;
    /** 创建人 */
    private Long              userId;
    /** 公告标题 */
    private String            annoTitle;
    /** 公告内容 */
    private String            annoContent;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
