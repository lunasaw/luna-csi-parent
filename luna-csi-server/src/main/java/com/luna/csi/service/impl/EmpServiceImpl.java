package com.luna.csi.service.impl;

import com.google.common.collect.Lists;
import com.luna.common.date.DateUtil;
import com.luna.common.dto.constant.ResultCode;
import com.luna.csi.dto.EmpDTO;
import com.luna.csi.exception.UserException;
import com.luna.csi.mapper.DeptMapper;
import com.luna.csi.mapper.EmpMapper;
import com.luna.csi.mapper.JobMapper;
import com.luna.csi.service.EmpService;
import com.luna.csi.entity.Emp;
import javax.annotation.Resource;

import com.luna.csi.utils.DO2DTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: luna
 * @CreateTime: 2021-04-28 15:46:27
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper  empMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private JobMapper  jobMapper;

    @Override
    public Emp getById(Long id) {
        Emp byId = empMapper.getById(id);
        return byId;
    }

    @Override
    public Emp getByEntity(Emp emp) {
        return empMapper.getByEntity(emp);
    }

    @Override
    public List<Emp> listByEntity(Emp emp) {
        return empMapper.listByEntity(emp);
    }

    @Override
    public PageInfo listPageByEntity(int page, int pageSize, Emp emp) {
        PageHelper.startPage(page, pageSize);
        List<Emp> list = empMapper.listByEntity(emp);
        PageInfo pageInfo = new PageInfo(list);
        List<Emp> empList = pageInfo.getList();
        ArrayList<EmpDTO> objects = Lists.newArrayList();
        for (Emp empDO : empList) {
            EmpDTO empDTO = DO2DTOUtils.Emp2EmpDTO(empDO);
            String jobName = jobMapper.getById(empDO.getJobId()).getJobName();
            empDTO.setJobName(jobName);
            String deptName = deptMapper.getById(empDO.getDeptId()).getDeptName();
            empDTO.setDeptName(deptName);
            objects.add(empDTO);
        }
        pageInfo.setList(objects);
        return pageInfo;
    }

    @Override
    public PageInfo listPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Emp> list = empMapper.listByEntity(new Emp());
        return new PageInfo(list);
    }

    @Override
    public List<Emp> listByIds(List<Long> ids) {
        return empMapper.listByIds(ids);
    }

    @Override
    public int insert(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public int insertBatch(List<Emp> list) {
        return empMapper.insertBatch(list);
    }

    @Override
    public int update(Emp emp) {
        Emp byId = empMapper.getById(emp.getId());
        if (byId == null) {
            throw new UserException(ResultCode.PARAMETER_INVALID, "员工不存在");
        }
        byId.setDeptId(emp.getDeptId());
        byId.setJobId(emp.getJobId());
        byId.setEmpName(emp.getEmpName());
        byId.setCardId(emp.getCardId());
        byId.setEmpAddress(emp.getEmpAddress());
        byId.setPostCode(emp.getPostCode());
        byId.setEmpTel(emp.getEmpTel());
        byId.setEmpPhone(emp.getEmpPhone());
        byId.setQqNum(emp.getQqNum());
        byId.setEmpEmail(emp.getEmpEmail());
        byId.setEmpSex(emp.getEmpSex());
        byId.setEmpParty(emp.getEmpParty());
        byId.setEmpBirthday(emp.getEmpBirthday());
        byId.setEmpRace(emp.getEmpRace());
        byId.setEmpEdu(emp.getEmpEdu());
        byId.setEmpMajor(emp.getEmpMajor());
        byId.setEmpHobby(emp.getEmpHobby());
        byId.setEmpRemark(emp.getEmpRemark());

        return empMapper.update(byId);
    }

    @Override
    public int updateBatch(List<Emp> list) {
        return empMapper.updateBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return empMapper.deleteById(id);
    }

    @Override
    public int deleteByEntity(Emp emp) {
        return empMapper.deleteByEntity(emp);
    }

    @Override
    public int deleteByIds(List<Long> list) {
        return empMapper.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return empMapper.countAll();
    }

    @Override
    public int countByEntity(Emp emp) {
        return empMapper.countByEntity(emp);
    }

}
