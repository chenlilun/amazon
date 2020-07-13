package com.xuecheng.manage_cms.cms.response;

import com.xuecheng.manage_cms.model.response.ResponseResult;
import com.xuecheng.manage_cms.model.response.ResultCode;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 */
@Data
public class GenerateHtmlResult extends ResponseResult {
    String html;
    public GenerateHtmlResult(ResultCode resultCode, String html) {
        super(resultCode);
        this.html = html;
    }
}
