package com.luna.csi.rest;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.luna.common.dto.ResultDTO;
import com.luna.common.dto.constant.ResultCode;
import com.luna.csi.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luna.csi.entity.Document;
import com.luna.csi.service.DocumentService;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: luna
 * @CreateTime: 2021-05-06 10:55:59
 */
@RestController
@RequestMapping("/document/api")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/get/{id}")
    public ResultDTO<Document> getById(@PathVariable(value = "id") Long id) {
        Document document = documentService.getById(id);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, document);
    }

    @GetMapping("/get")
    public ResultDTO<Document> getByEntity(Document document) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, documentService.getByEntity(document));
    }

    @GetMapping("/list")
    public ResultDTO<List<Document>> list(Document document) {
        List<Document> documentList = documentService.listByEntity(document);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, documentList);
    }

    @GetMapping("/pageListByEntity/{page}/{size}")
    public ResultDTO<PageInfo> listPageByEntity(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size, Document document) {
        PageInfo pageInfo = documentService.listPageByEntity(page, size, document);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @GetMapping("/pageList/{page}/{size}")
    public ResultDTO<PageInfo> listPage(@PathVariable(value = "page") int page,
        @PathVariable(value = "size") int size) {
        PageInfo pageInfo = documentService.listPage(page, size);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, pageInfo);
    }

    @PostMapping("/insert")
    public ResultDTO<Document> insert(HttpServletRequest request, @RequestBody Document document) {
        documentService.insert(CookieUtils.getOneSessionKey(request), document);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, document);
    }

    @PostMapping("/insertBatch")
    public ResultDTO<List<Document>> insert(@RequestBody List<Document> list) {
        documentService.insertBatch(list);
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, list);
    }

    @PutMapping("/update")
    public ResultDTO<Boolean> update(@RequestBody Document document) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, documentService.update(document) == 1);
    }

    @PutMapping("/updateBatch")
    public ResultDTO<Boolean> update(@RequestBody List<Document> list) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            documentService.updateBatch(list) == list.size());
    }

    @DeleteMapping("/delete/{id}")
    public ResultDTO<Boolean> deleteOne(@PathVariable(value = "id") Long id) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, documentService.deleteById(id) == 1);
    }

    @DeleteMapping("/deleteByEntity")
    public ResultDTO<Boolean> deleteOne(@RequestBody Document document) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            documentService.deleteByEntity(document) == 1);
    }

    @DeleteMapping("/delete")
    public ResultDTO<Integer> deleteBatch(@RequestBody List<Long> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) {
            result = documentService.deleteByIds(ids);
        }
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, result);
    }

    @GetMapping("/account")
    public ResultDTO<Integer> getAccount() {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, documentService.countAll());
    }

    @GetMapping("/accountByEntity")
    public ResultDTO<Integer> getAccountByEntity(Document document) {
        return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,
            documentService.countByEntity(document));
    }
}
