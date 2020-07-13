package com.xuecheng.manage_cms.dao;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 18:11
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class GridFsTempleteTest {

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Test
    public void cun() throws  Exception{
        File file = new File("E:\\cms\\cmsService\\test-freemarker\\src\\main\\resources\\templates\\index_banner.ftl") ;
        FileInputStream fis = new FileInputStream(file) ;
        ObjectId o = gridFsTemplate.store(fis, "index_banner.ftl");
        System.out.println(o);

    }


}
