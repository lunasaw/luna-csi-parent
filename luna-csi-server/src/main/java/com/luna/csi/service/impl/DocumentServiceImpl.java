package com.luna.csi.service.impl;

import com.luna.csi.config.LoginInterceptor;
import com.luna.csi.dto.DocumentDTO;
import com.luna.csi.entity.User;
import com.luna.csi.mapper.DocumentMapper;
import com.luna.csi.mapper.UserMapper;
import com.luna.csi.service.DocumentService;
import com.luna.csi.entity.Document;
import com.luna.csi.utils.DO2DTOUtils;
import com.luna.redis.util.RedisHashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: luna
 * @CreateTime: 2021-05-06 10:55:59
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private UserMapper     userMapper;

    @Autowired
    private RedisHashUtil  redisHashUtil;

    @Override
    public Document getById(Long id) {
        return documentMapper.getById(id);
    }

    @Override
    public Document getByEntity(Document document) {
        return documentMapper.getByEntity(document);
    }

    @Override
    public List<Document> listByEntity(Document document) {
        return documentMapper.listByEntity(document);
    }

    @Override
    public PageInfo listPageByEntity(int page, int pageSize, Document document) {
        PageHelper.startPage(page, pageSize);
        List<Document> list = documentMapper.listByEntity(document);
        PageInfo pageInfo = new PageInfo(list);
        List<DocumentDTO> collect = list.stream().map(document1 -> {
            String username = userMapper.getById(document1.getCreateBy()).getUsername();
            return DO2DTOUtils.document2DocumentDTO(document1, username);
        }).collect(Collectors.toList());
        pageInfo.setList(collect);
        return pageInfo;
    }

    @Override
    public PageInfo listPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Document> list = documentMapper.listByEntity(new Document());
        return new PageInfo(list);
    }

    @Override
    public List<Document> listByIds(List<Long> ids) {
        return documentMapper.listByIds(ids);
    }

    @Override
    public int insert(String sessionKey, Document document) {
        User user = (User)redisHashUtil.get(LoginInterceptor.sessionKey + ":" + sessionKey, sessionKey);
        document.setCreateBy(user.getId());
        return documentMapper.insert(document);
    }

    @Override
    public int insertBatch(List<Document> list) {
        return documentMapper.insertBatch(list);
    }

    @Override
    public int update(Document document) {
        return documentMapper.update(document);
    }

    @Override
    public int updateBatch(List<Document> list) {
        return documentMapper.updateBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return documentMapper.deleteById(id);
    }

    @Override
    public int deleteByEntity(Document document) {
        return documentMapper.deleteByEntity(document);
    }

    @Override
    public int deleteByIds(List<Long> list) {
        return documentMapper.deleteByIds(list);
    }

    @Override
    public int countAll() {
        return documentMapper.countAll();
    }

    @Override
    public int countByEntity(Document document) {
        return documentMapper.countByEntity(document);
    }

}
