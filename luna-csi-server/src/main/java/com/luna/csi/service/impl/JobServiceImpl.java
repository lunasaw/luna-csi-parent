package com.luna.csi.service.impl;

import com.luna.common.dto.constant.ResultCode;
import com.luna.csi.exception.UserException;
import com.luna.csi.mapper.JobMapper;
import com.luna.csi.service.JobService;
import com.luna.csi.entity.Job;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-04-28 15:46:12
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Override
    public Job getById(Long id) {
        return jobMapper.getById(id);
    }

    @Override
    public Job getByEntity(Job job) {
        return jobMapper.getByEntity(job);
    }

    @Override
    public List<Job> listByEntity(Job job) {
        return jobMapper.listByEntity(job);
    }

    @Override
    public PageInfo listPageByEntity(int page, int pageSize, Job job) {
        PageHelper.startPage(page, pageSize);
        List<Job> list = jobMapper.listByEntity(job);
        return new PageInfo(list);
    }

    @Override
    public PageInfo listPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Job> list = jobMapper.listByEntity(new Job());
        return new PageInfo(list);
    }

    @Override
    public List<Job> listByIds(List<Long> ids) {
        return jobMapper.listByIds(ids);
    }

    @Override
    public int insert(Job job) {
        return jobMapper.insert(job);
    }

    @Override
    public int insertBatch(List<Job> list) {
        return jobMapper.insertBatch(list);
    }

    @Override
    public int update(Job job) {
        Job byId = jobMapper.getById(job.getId());

        if (byId == null) {
            throw new UserException(ResultCode.PARAMETER_INVALID, "职位不存在");
        }

        byId.setJobName(job.getJobName());
        byId.setJobRemark(job.getJobRemark());
        return jobMapper.update(byId);
    }

    @Override
    public int updateBatch(List<Job> list) {
        return jobMapper.updateBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return jobMapper.deleteById(id);
    }

    @Override
    public int deleteByEntity(Job job) {
        return jobMapper.deleteByEntity(job);
    }

    @Override
    public int deleteByIds(List<Long> list) {
        return jobMapper.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return jobMapper.countAll();
    }

    @Override
    public int countByEntity(Job job) {
        return jobMapper.countByEntity(job);
    }

}
