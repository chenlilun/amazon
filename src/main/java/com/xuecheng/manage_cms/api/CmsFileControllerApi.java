package com.xuecheng.manage_cms.api;

import com.xuecheng.manage_cms.cms.FileMetadata;
import com.xuecheng.manage_cms.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Api(value="文件管理接口",description = "提供文件下载跟上传")
public interface CmsFileControllerApi {

//
//    @ApiOperation("新增cmspage")
//    public CmsPageResult  add(CmsPage cmsPage) ;



    @ApiOperation("上传文件")
    public String httpUpload(@RequestParam("files") MultipartFile file) ;
    @ApiOperation("文件列表")
    QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, FileMetadata queryPageRequest) ;
}
