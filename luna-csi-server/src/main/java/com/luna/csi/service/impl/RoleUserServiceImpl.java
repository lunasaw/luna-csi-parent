package com.luna.csi.service.impl;

import com.luna.csi.mapper.RoleUserMapper;
import com.luna.csi.service.RoleUserService;
import com.luna.csi.entity.RoleUser;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-04-28 15:45:58
 */
@Service
public class RoleUserServiceImpl implements RoleUserService {

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public RoleUser getById(Long id) {
        return roleUserMapper.getById(id);
    }

    @Override
    public RoleUser getByEntity(RoleUser roleUser) {
        return roleUserMapper.getByEntity(roleUser);
    }

    @Override
    public List<RoleUser> listByEntity(RoleUser roleUser) {
        return roleUserMapper.listByEntity(roleUser);
    }

    @Override
    public PageInfo listPageByEntity(int page, int pageSize, RoleUser roleUser) {
        PageHelper.startPage(page, pageSize);
        List<RoleUser> list = roleUserMapper.listByEntity(roleUser);
        return new PageInfo(list);
    }

    @Override
    public PageInfo listPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<RoleUser> list = roleUserMapper.listByEntity(new RoleUser());
        return new PageInfo(list);
    }

    @Override
    public List<RoleUser> listByIds(List<Long> ids) {
        return roleUserMapper.listByIds(ids);
    }

    @Override
    public int insert(RoleUser roleUser) {
        Date date = new Date();
        roleUser.setCreateTime(date);
        roleUser.setModifiedTime(date);
        return roleUserMapper.insert(roleUser);
    }

    @Override
    public int insertBatch(List<RoleUser> list) {
        return roleUserMapper.insertBatch(list);
    }

    @Override
    public int update(RoleUser roleUser) {
        roleUser.setModifiedTime(new Date());
        return roleUserMapper.update(roleUser);
    }

    @Override
    public int updateBatch(List<RoleUser> list) {
        return roleUserMapper.updateBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return roleUserMapper.deleteById(id);
    }

    @Override
    public int deleteByEntity(RoleUser roleUser) {
        return roleUserMapper.deleteByEntity(roleUser);
    }

    @Override
    public int deleteByIds(List<Long> list) {
        return roleUserMapper.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return roleUserMapper.countAll();
    }

    @Override
    public int countByEntity(RoleUser roleUser) {
        return roleUserMapper.countByEntity(roleUser);
    }

}
