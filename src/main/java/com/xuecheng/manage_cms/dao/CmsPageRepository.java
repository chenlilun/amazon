package com.xuecheng.manage_cms.dao;


import com.xuecheng.manage_cms.cms.CmsPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsPageRepository extends MongoRepository<CmsPage,String> {
    //根据页面名称查询
    CmsPage findByPageName(String pageName);
    CmsPage findByPageNameAndPageWebPathAndSiteId(String pageName , String pageWebPath , String siteId) ;
    CmsPage findBySiteId(String  siteId ) ;

}
