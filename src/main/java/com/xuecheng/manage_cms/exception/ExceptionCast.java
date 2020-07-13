package com.xuecheng.manage_cms.exception;


import com.xuecheng.manage_cms.model.response.ResultCode;

public class ExceptionCast {
    public static void  cast(ResultCode resultCode){
      throw new CustomException(resultCode) ;
    }
}
