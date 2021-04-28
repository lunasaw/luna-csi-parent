package com.luna.csi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户角色表(RoleUser)实体类
 *
 * @author luna
 * @since 2021-04-28 15:45:57
 */
public class RoleUser implements Serializable {
    private static final long serialVersionUID = -17008878323639327L;
    /** 角色编号 */
    private Long              id;
    /** 角色名称 */
    private String            roleName;
    /** 用户编号 */
    private Long              userId;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
