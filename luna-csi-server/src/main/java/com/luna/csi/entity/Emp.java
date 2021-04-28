package com.luna.csi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 员工信息表(Emp)实体类
 *
 * @author luna
 * @since 2021-04-28 15:46:27
 */
public class Emp implements Serializable {
    private static final long serialVersionUID = 470931488518673680L;
    /** 员工编号 */
    private Long              id;
    /** 部门编号 */
    private Long              deptId;
    /** 职位编号 */
    private Long              jobId;
    /** 员工名称 */
    private String            empName;
    /** 身份码 */
    private String            cardId;
    /** 员工地址 */
    private String            empAddress;
    private String            postCode;
    /** 员工电话 */
    private String            empTel;
    /** 员工手机 */
    private String            empPhone;
    /** QQ */
    private String            qqNum;
    /** 邮箱 */
    private String            empEmail;
    /** 性别 */
    private Integer           empSex;
    /** 政治面貌 */
    private String            empParty;
    /** 生日 */
    private Date              empBirthday;
    /** 民族 */
    private String            empRace;
    /** 学位 */
    private String            empEdu;
    /** 经理 */
    private String            empMajor;
    /** 爱好 */
    private String            empHobby;
    private String            empRemark;
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

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
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

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Integer getEmpSex() {
        return empSex;
    }

    public void setEmpSex(Integer empSex) {
        this.empSex = empSex;
    }

    public String getEmpParty() {
        return empParty;
    }

    public void setEmpParty(String empParty) {
        this.empParty = empParty;
    }

    public Date getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(Date empBirthday) {
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
