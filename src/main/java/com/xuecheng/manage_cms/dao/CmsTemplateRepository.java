package com.xuecheng.manage_cms.dao;


import com.xuecheng.manage_cms.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsTemplateRepository extends MongoRepository<CmsTemplate,String> {
}
