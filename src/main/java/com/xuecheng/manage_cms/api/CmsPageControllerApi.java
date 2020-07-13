package com.xuecheng.manage_cms.api;


import com.xuecheng.manage_cms.cms.CmsPage;
import com.xuecheng.manage_cms.cms.request.QueryPageRequest;
import com.xuecheng.manage_cms.cms.response.CmsPageResult;
import com.xuecheng.manage_cms.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="cms页面管理接口",description = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {
    //页面查询
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    @ApiOperation("新增cmspage")
    public CmsPageResult add(CmsPage cmsPage) ;

    @ApiOperation("通过ID查询页面")
    public CmsPageResult findById(String id);
    @ApiOperation("修改页面")
    public CmsPageResult edit(String id, CmsPage cmsPage);

    @ApiOperation("删除")
    public ResponseResult deleteById(String id);
}
