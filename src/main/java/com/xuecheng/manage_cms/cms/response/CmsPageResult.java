package com.xuecheng.manage_cms.cms.response;


import com.xuecheng.manage_cms.cms.CmsPage;
import com.xuecheng.manage_cms.model.response.ResponseResult;
import com.xuecheng.manage_cms.model.response.ResultCode;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 */
@Data
public class CmsPageResult extends ResponseResult {
    CmsPage cmsPage;
    public CmsPageResult(ResultCode resultCode, CmsPage cmsPage) {
        super(resultCode);
        this.cmsPage = cmsPage;
    }
}
