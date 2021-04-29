package com.luna.csi.service.impl;

import com.luna.common.dto.constant.ResultCode;
import com.luna.common.encrypt.Md5Utils;
import com.luna.csi.exception.UserException;
import com.luna.csi.mapper.UserMapper;
import com.luna.csi.service.UserService;
import com.luna.csi.entity.User;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-04-28 15:45:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }

    @Override
    public User getByEntity(User user) {
        return userMapper.getByEntity(user);
    }

    @Override
    public List<User> listByEntity(User user) {
        return userMapper.listByEntity(user);
    }

    @Override
    public PageInfo listPageByEntity(int page, int pageSize, User user) {
        PageHelper.startPage(page, pageSize);
        List<User> list = userMapper.listByEntity(user);
        return new PageInfo(list);
    }

    @Override
    public PageInfo listPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<User> list = userMapper.listByEntity(new User());
        return new PageInfo(list);
    }

    @Override
    public List<User> listByIds(List<Long> ids) {
        return userMapper.listByIds(ids);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int insertBatch(List<User> list) {
        return userMapper.insertBatch(list);
    }

    @Override
    public int update(User user) {
        User byEntity = userMapper.getById(user.getId());
        if (byEntity == null) {
            throw new UserException(ResultCode.PARAMETER_INVALID, "用户不存在");
        }
        byEntity.setUsername(user.getUsername());
        byEntity.setPassword(Md5Utils.md5(Md5Utils.md5(user.getPassword())));
        byEntity.setGender(user.getGender());
        byEntity.setCellphone(user.getCellphone());
        byEntity.setEmail(user.getEmail());
        byEntity.setStatus(user.getStatus());
        byEntity.setFaceurl(user.getFaceurl());
        byEntity.setFacedata(user.getFacedata());
        return userMapper.update(byEntity);
    }

    @Override
    public int updateBatch(List<User> list) {
        return userMapper.updateBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int deleteByEntity(User user) {
        return userMapper.deleteByEntity(user);
    }

    @Override
    public int deleteByIds(List<Long> list) {
        return userMapper.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return userMapper.countAll();
    }

    @Override
    public int countByEntity(User user) {
        return userMapper.countByEntity(user);
    }

}
