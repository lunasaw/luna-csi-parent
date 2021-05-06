package com.luna.csi.utils;

import com.alibaba.fastjson.JSON;
import com.luna.common.date.DateUtil;
import com.luna.csi.dto.AnnoDTO;
import com.luna.csi.dto.DocumentDTO;
import com.luna.csi.dto.EmpDTO;
import com.luna.csi.entity.Anno;
import com.luna.csi.entity.Document;
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

    public static DocumentDTO document2DocumentDTO(Document document, String userName) {
        if (document == null) {
            return null;
        }
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setId(document.getId());
        documentDTO.setCreateBy(userName);
        documentDTO.setFileTitle(document.getFileTitle());
        documentDTO.setFileDescription(document.getFileDescription());
        documentDTO.setFileUrl(document.getFileUrl());
        documentDTO.setCreateTime(DateUtil.parseDateToStr(DateUtil.YYYY_MM_DD, document.getCreateTime()));
        documentDTO.setModifiedTime(DateUtil.parseDateToStr(DateUtil.YYYY_MM_DD, document.getModifiedTime()));
        documentDTO.setVersion(document.getVersion());
        return documentDTO;
    }

    public static AnnoDTO Anno2AnnoDTO(Anno anno, String username) {
        if (anno == null) {
            return null;
        }
        AnnoDTO annoDTO = new AnnoDTO();
        annoDTO.setId(anno.getId());
        annoDTO.setCreateBy(username);
        annoDTO.setAnnoTitle(anno.getAnnoTitle());
        annoDTO.setAnnoContent(anno.getAnnoContent());
        annoDTO.setCreateTime(DateUtil.parseDateToStr(DateUtil.YYYY_MM_DD, anno.getCreateTime()));
        annoDTO.setModifiedTime(DateUtil.parseDateToStr(DateUtil.YYYY_MM_DD, anno.getCreateTime()));
        annoDTO.setVersion(anno.getVersion());
        return annoDTO;
    }
}
