package com.luna.csi.service.impl;

import com.luna.csi.mapper.DeptMapper;
import com.luna.csi.service.DeptService;
import com.luna.csi.entity.Dept;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-04-28 15:46:45
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept getById(Long id) {
        return deptMapper.getById(id);
    }

    @Override
    public Dept getByEntity(Dept dept) {
        return deptMapper.getByEntity(dept);
    }

    @Override
    public List<Dept> listByEntity(Dept dept) {
        return deptMapper.listByEntity(dept);
    }

    @Override
    public PageInfo listPageByEntity(int page, int pageSize, Dept dept) {
        PageHelper.startPage(page, pageSize);
        List<Dept> list = deptMapper.listByEntity(dept);
        return new PageInfo(list);
    }

    @Override
    public PageInfo listPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Dept> list = deptMapper.listByEntity(new Dept());
        return new PageInfo(list);
    }

    @Override
    public List<Dept> listByIds(List<Long> ids) {
        return deptMapper.listByIds(ids);
    }

    @Override
    public int insert(Dept dept) {
        Date date = new Date();
        dept.setCreateTime(date);
        dept.setModifiedTime(date);
        return deptMapper.insert(dept);
    }

    @Override
    public int insertBatch(List<Dept> list) {
        return deptMapper.insertBatch(list);
    }

    @Override
    public int update(Dept dept) {
        dept.setModifiedTime(new Date());
        return deptMapper.update(dept);
    }

    @Override
    public int updateBatch(List<Dept> list) {
        return deptMapper.updateBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return deptMapper.deleteById(id);
    }

    @Override
    public int deleteByEntity(Dept dept) {
        return deptMapper.deleteByEntity(dept);
    }

    @Override
    public int deleteByIds(List<Long> list) {
        return deptMapper.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return deptMapper.countAll();
    }

    @Override
    public int countByEntity(Dept dept) {
        return deptMapper.countByEntity(dept);
    }

}
