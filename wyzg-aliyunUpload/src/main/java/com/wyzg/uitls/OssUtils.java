package com.wyzg.uitls;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.wyzg.config.OssConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author raintrees
 * @date 2019/11/25 14:33
 */
@Component
public class OssUtils {

    @Autowired
    private OssConfig ossConfig;

    public String upload(File file){

        if(file == null ){
            return null;
        }
        String accesskeyId = ossConfig.getLXIMAGE_ACCESS_KEY_ID();
        String accessKeySecret = ossConfig.getLXIMAGE_ACCESS_KEY_SECRET();
        String bucketName=ossConfig.getLXIMAGE_BUCKET_NAME();
        String endPoint=ossConfig.getLXIMAGE_END_POINT();
        String hostName=ossConfig.getLXIMAGE_FILE_HOST();
        //阿里云客户端对象
        OSSClient client = new OSSClient(endPoint, accesskeyId, accessKeySecret);

        try{
            if(!client.doesBucketExist(bucketName)){
                //当桶不存在是创建桶
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                //访问控制器设置为公共读
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                client.createBucket(createBucketRequest);
            }

            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = dateFormat.format(new Date());
            String key=hostName+"/"+currentDate+"/"+ UUID.randomUUID().toString().replace("-","")+"-"+file.getName();
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
            PutObjectResult result = client.putObject(putObjectRequest);
            client.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);
            if(result != null){
                return key;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(client != null){
                client.shutdown();
            }
        }
        return null;
    }
}
