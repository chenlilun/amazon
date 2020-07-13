package com.xuecheng.manage_cms.controller;


import com.alibaba.fastjson.JSONObject;

import com.xuecheng.manage_cms.api.CmsFileControllerApi;
import com.xuecheng.manage_cms.cms.FileMetadata;
import com.xuecheng.manage_cms.dao.FileMetadataRepo;
import com.xuecheng.manage_cms.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.FileService;
import com.xuecheng.manage_cms.service.MongoFileRepo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Author: lqs
 * @Date: 2019/12/30 15:01
 */
@RestController
@RequestMapping("/cms/file")
public class UploadFilesController implements CmsFileControllerApi {
    @Autowired
    private MongoFileRepo mongoFileRepo;
    @Autowired
    private FileMetadataRepo fileMetadataRepo;

    @Autowired
    private FileService fileService;


    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, FileMetadata queryPageRequest) {
        return fileService.findList(page, size, queryPageRequest);
    }

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String httpUpload(@RequestParam("files") MultipartFile file) {
        JSONObject object = new JSONObject();
        String comment = "上传文件";//备注
        FileMetadata fileMetadata = new FileMetadata();
        fileMetadata.setAssociateId("10086");
        fileMetadata.setUploadTime(Timestamp.valueOf(LocalDateTime.now()));//上传时间
        fileMetadata.setFileOrder(1);//排序
        fileMetadata.setComment(comment);
        fileMetadata.setYear(2019);//年份
        fileMetadata.setFileOriginName(file.getOriginalFilename());//文件名
        fileMetadata.setOperator("会飞的鱼");//操作人
        // 下面这三个应该是什么？
        fileMetadata.setFileType(null);
        fileMetadata.setFileDisplayName(null);
        fileMetadata.setAssociateObjectClass(null);
        try {
            String id = mongoFileRepo.saveFile(file, comment);
            fileMetadata.setId(id);
            fileMetadataRepo.save(fileMetadata);
            object.put("result", "文件上传成功");
        } catch (Exception e) {
            object.put("result", "文件失败");
        }
        return object.toString();
    }

    /**
     * 文件下载
     *
     * @param id
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping("/downLoad")
    @ResponseBody
    public void downLoad(String id, HttpServletResponse response, HttpServletRequest request) throws Exception {
        mongoFileRepo.getFileById(id, response, request);
    }

    @DeleteMapping("/delFile/{id}")
    @ResponseBody
    public ResponseResult delFileById(@PathVariable("id") String id) {
        return fileService.delFileById(id);
    }
}

