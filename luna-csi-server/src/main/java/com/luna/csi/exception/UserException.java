package com.luna.csi.exception;

import com.luna.common.exception.BaseException;

public class UserException extends BaseException {

    public UserException(int code, String message) {
        super(code, message);
    }
}