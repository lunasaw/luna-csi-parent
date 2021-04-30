package com.luna.csi.dto;

import java.util.Date;

/**
 * @author luna@mac
 * 2021年04月30日 08:42
 */
public class EmpDTO {
    /** 员工编号 */
    private Long   id;
    /** 部门名称 */
    private String deptName;
    /** 职位名称 */
    private String jobName;
    /** 员工名称 */
    private String empName;
    /** 身份码 */
    private String cardId;
    /** 员工地址 */
    private String empAddress;

    private String postCode;
    /** 员工电话 */
    private String empTel;
    /** 员工手机 */
    private String empPhone;
    /** QQ */
    private String qqNum;
    /** 邮箱 */
    private String empEmail;
    /** 性别 */
    private String empSex;
    /** 政治面貌 */
    private String empParty;
    /** 生日 */
    private String empBirthday;
    /** 民族 */
    private String empRace;
    /** 学位 */
    private String empEdu;
    /** 经理 */
    private String empMajor;
    /** 爱好 */
    private String empHobby;
    private String empRemark;
    /** 创建时间 */
    private Date   createTime;
    /** 修改时间 */
    private Date   modifiedTime;
    /** 锁 */
    private Object version;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmpTel() {
        return empTel;
    }

    public void setEmpTel(String empTel) {
        this.empTel = empTel;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpParty() {
        return empParty;
    }

    public void setEmpParty(String empParty) {
        this.empParty = empParty;
    }

    public String getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(String empBirthday) {
        this.empBirthday = empBirthday;
    }

    public String getEmpRace() {
        return empRace;
    }

    public void setEmpRace(String empRace) {
        this.empRace = empRace;
    }

    public String getEmpEdu() {
        return empEdu;
    }

    public void setEmpEdu(String empEdu) {
        this.empEdu = empEdu;
    }

    public String getEmpMajor() {
        return empMajor;
    }

    public void setEmpMajor(String empMajor) {
        this.empMajor = empMajor;
    }

    public String getEmpHobby() {
        return empHobby;
    }

    public void setEmpHobby(String empHobby) {
        this.empHobby = empHobby;
    }

    public String getEmpRemark() {
        return empRemark;
    }

    public void setEmpRemark(String empRemark) {
        this.empRemark = empRemark;
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
