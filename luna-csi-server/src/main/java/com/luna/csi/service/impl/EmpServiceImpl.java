package com.luna.csi.service.impl;

import com.luna.csi.mapper.EmpMapper;
import com.luna.csi.service.EmpService;
import com.luna.csi.entity.Emp;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-04-28 15:46:27
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp getById(Long id) {
        return empMapper.getById(id);
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
        return new PageInfo(list);
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
        Date date = new Date();
        emp.setCreateTime(date);
        emp.setModifiedTime(date);
        return empMapper.insert(emp);
    }

    @Override
    public int insertBatch(List<Emp> list) {
        return empMapper.insertBatch(list);
    }

    @Override
    public int update(Emp emp) {
        emp.setModifiedTime(new Date());
        return empMapper.update(emp);
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
