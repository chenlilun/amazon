package com.xuecheng.manage_cms.exception;

import com.xuecheng.manage_cms.model.response.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionCatch {
    //捕获customexception
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult getException(CustomException cException){
        return  new ResponseResult(cException.getResultCode());
    }
}
