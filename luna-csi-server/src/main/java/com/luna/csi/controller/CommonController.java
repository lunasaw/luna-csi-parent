package com.luna.csi.controller;

import com.luna.common.dto.ResultDTO;
import com.luna.common.dto.constant.ResultCode;
import com.luna.csi.config.ServerConfig;
import com.luna.csi.entity.Document;
import com.luna.csi.service.DocumentService;
import com.luna.csi.utils.FileUploadUtils;
import com.luna.csi.utils.FileUtils;
import com.luna.csi.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author luna@mac
 * 2021年05月06日 11:35
 */
@RestController
@RequestMapping("/document")
public class CommonController {

    /** Nginx 文件服务器 */
    public static final String  PATH = "http://127.0.0.1:8081";

    @Autowired
    private DocumentService     documentService;

    private static final Logger log  = LoggerFactory.getLogger(CommonController.class);

    /**
     * 通用上传请求
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResultDTO<Document> uploadFile(Document document, MultipartFile file) {
        try {
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(file);
            String url = PATH + fileName;
            document.setFileUrl(url);
            if (document.getId() != null) {
                Document byId = documentService.getById(document.getId());
                if (byId != null) {
                    byId.setFileUrl(url);
                    documentService.update(byId);
                    return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, byId);
                } else {
                    return new ResultDTO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
                }
            } else {
                documentService.insert(document);
                return new ResultDTO<>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, document);
            }
        } catch (Exception e) {
            return new ResultDTO<>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID);
        }
    }
}
