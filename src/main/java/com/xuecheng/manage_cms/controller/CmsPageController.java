package com.xuecheng.manage_cms.controller;


import com.xuecheng.manage_cms.api.CmsPageControllerApi;
import com.xuecheng.manage_cms.cms.CmsPage;
import com.xuecheng.manage_cms.cms.request.QueryPageRequest;
import com.xuecheng.manage_cms.cms.response.CmsPageResult;
import com.xuecheng.manage_cms.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 17:24
 **/
@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    PageService pageService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, QueryPageRequest queryPageRequest) {
        return pageService.findList(page,size,queryPageRequest);
    }

    @Override
    @PostMapping("/add")
    public CmsPageResult add(@RequestBody CmsPage cmsPage) {

        return pageService.add(cmsPage);
    }

    @GetMapping("/a")
    public  String getString (){
        return  "test";
    }

    @Override
    @GetMapping("/get/{id}")
    public CmsPageResult findById(@PathVariable("id") String id) {
        return pageService.getById(id);
    }

    @Override
    @PutMapping("/put/{id}")
    public CmsPageResult edit(@PathVariable("id") String id, @RequestBody  CmsPage cmsPage) {
        return pageService.update(id,cmsPage);
    }


    @Override
    @DeleteMapping("/del/{id}")
    public ResponseResult deleteById(@PathVariable("id") String id) {
        return pageService.delete(id);
    }
}
