package com.luna.csi.service.impl;

import com.luna.csi.mapper.AnnoMapper;
import com.luna.csi.service.AnnoService;
import com.luna.csi.entity.Anno;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;

/**
 * @Author: luna
 * @CreateTime: 2021-04-30 11:42:35
 */
@Service
public class AnnoServiceImpl implements AnnoService {

    @Autowired
    private AnnoMapper annoMapper;

    @Override
    public Anno getById(Long id) {
        return annoMapper.getById(id);
    }

    @Override
    public Anno getByEntity(Anno anno) {
        return annoMapper.getByEntity(anno);
    }

    @Override
    public List<Anno> listByEntity(Anno anno) {
        return annoMapper.listByEntity(anno);
    }

    @Override
    public PageInfo listPageByEntity(int page, int pageSize, Anno anno) {
        PageHelper.startPage(page, pageSize);
        List<Anno> list = annoMapper.listByEntity(anno);
        return new PageInfo(list);
    }

    @Override
    public PageInfo listPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Anno> list = annoMapper.listByEntity(new Anno());
        return new PageInfo(list);
    }

    @Override
    public List<Anno> listByIds(List<Long> ids) {
        return annoMapper.listByIds(ids);
    }

    @Override
    public int insert(Anno anno) {
        return annoMapper.insert(anno);
    }

    @Override
    public int insertBatch(List<Anno> list) {
        return annoMapper.insertBatch(list);
    }

    @Override
    public int update(Anno anno) {
        return annoMapper.update(anno);
    }

    @Override
    public int updateBatch(List<Anno> list) {
        return annoMapper.updateBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return annoMapper.deleteById(id);
    }

    @Override
    public int deleteByEntity(Anno anno) {
        return annoMapper.deleteByEntity(anno);
    }

    @Override
    public int deleteByIds(List<Long> list) {
        return annoMapper.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return annoMapper.countAll();
    }

    @Override
    public int countByEntity(Anno anno) {
        return annoMapper.countByEntity(anno);
    }

}
