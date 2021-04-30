package com.luna.csi.utils;

import com.alibaba.fastjson.JSON;
import com.luna.common.date.DateUtil;
import com.luna.csi.dto.EmpDTO;
import com.luna.csi.entity.Emp;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author luna@mac
 * 2021年04月30日 08:43
 */
public class DO2DTOUtils {

    public static EmpDTO Emp2EmpDTO(Emp emp) {
        if (emp == null) {
            return null;
        }
        EmpDTO empDTO = new EmpDTO();
        empDTO.setId(emp.getId());
        empDTO.setEmpName(emp.getEmpName());
        empDTO.setCardId(emp.getCardId());
        empDTO.setEmpAddress(emp.getEmpAddress());
        empDTO.setPostCode(emp.getPostCode());
        empDTO.setEmpTel(emp.getEmpTel());
        empDTO.setEmpPhone(emp.getEmpPhone());
        empDTO.setQqNum(emp.getQqNum());
        empDTO.setEmpEmail(emp.getEmpEmail());
        empDTO.setEmpSex(emp.getEmpSex() == 1 ? "男" : "女");
        empDTO.setEmpParty(emp.getEmpParty());
        empDTO.setEmpBirthday(DateUtil.parseDateToStr(DateUtil.YYYY_MM_DD, emp.getEmpBirthday()));
        empDTO.setEmpRace(emp.getEmpRace());
        empDTO.setEmpEdu(emp.getEmpEdu());
        empDTO.setEmpMajor(Objects.equals(emp.getEmpMajor(), "1") ? "是" : "否");
        empDTO.setEmpHobby(emp.getEmpHobby());
        empDTO.setEmpRemark(StringUtils.isEmpty(emp.getEmpRemark()) ? "" : JSON.toJSONString(emp.getEmpRemark()));
        empDTO.setCreateTime(emp.getCreateTime());
        empDTO.setModifiedTime(emp.getModifiedTime());
        empDTO.setVersion(emp.getVersion());
        return empDTO;
    }
}
