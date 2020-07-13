package com.xuecheng.manage_cms.exception;

import com.xuecheng.manage_cms.model.response.ResultCode;
import lombok.Data;

@Data
public class CustomException extends RuntimeException {
    private ResultCode resultCode ;

    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
