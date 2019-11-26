package com.wyzg.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author raintrees
 * @date 2019/11/25 14:06
 */
@Configuration
@Setter
@Getter
@Component
public class OssConfig {


    @Value("${endpoint}")
    private String LXIMAGE_END_POINT;

    @Value("${accessKeyId}")
    private String LXIMAGE_ACCESS_KEY_ID;

    @Value("${accessKeySecret}")
    private String LXIMAGE_ACCESS_KEY_SECRET;

    @Value("${filehost}")
    private String LXIMAGE_FILE_HOST;

    @Value("${bucketName}")
    private String LXIMAGE_BUCKET_NAME;

    @Value("${urlPrefix}")
    private String urlPrefix;
}
