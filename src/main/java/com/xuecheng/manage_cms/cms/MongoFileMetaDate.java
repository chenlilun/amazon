package com.xuecheng.manage_cms.cms;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * 定义保存在mongoFile中的mongoData
 */
@Data
public class MongoFileMetaDate {
    @Id
    private String id ;
    private String fileName;
    private String relatedOrgId;
    private String uploadUser;
    private LocalDateTime uploadTime;
    private String comment;

}

