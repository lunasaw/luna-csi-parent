package com.luna.csi.exception;

import com.luna.common.exception.BaseException;

/**
 * 文件信息异常类
 **/
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    /**
     * 错误码对应的参数
     */
    private Object[]          args;

    public FileException(String code, Object[] args) {
        super(Integer.parseInt(code), "");
        this.args = args;
    }

}
