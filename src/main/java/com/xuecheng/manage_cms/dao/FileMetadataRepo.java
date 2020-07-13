package com.xuecheng.manage_cms.dao;

import com.xuecheng.manage_cms.cms.FileMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileMetadataRepo  extends MongoRepository<FileMetadata,String> {
}
