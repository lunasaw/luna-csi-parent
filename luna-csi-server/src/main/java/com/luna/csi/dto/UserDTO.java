package com.luna.csi.dto;

import java.util.Date;

/**
 * @author luna@mac
 * 2021年05月10日 21:22
 */
public class UserDTO {
    private Long    id;
    /** 用户名 */
    private String  username;
    /** 密码 */
    private String  password;
    /** 性别 */
    private String  gender;
    /** 手机 */
    private String  cellphone;
    /** 邮箱 */
    private String  email;
    /** 状态 */
    private Integer status;
    /** 人脸图片 */
    private String  faceurl;
    /** 人脸key */
    private String  facedata;
    /** 创建时间 */
    private String  createTime;
    /** 修改时间 */
    private String  modifiedTime;
    /** 锁 */
    private Object  version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFaceurl() {
        return faceurl;
    }

    public void setFaceurl(String faceurl) {
        this.faceurl = faceurl;
    }

    public String getFacedata() {
        return facedata;
    }

    public void setFacedata(String facedata) {
        this.facedata = facedata;
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
