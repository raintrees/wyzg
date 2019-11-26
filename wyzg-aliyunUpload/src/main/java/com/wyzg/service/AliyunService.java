package com.wyzg.service;

import com.wyzg.config.OssConfig;
import com.wyzg.uitls.OssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author raintrees
 * @date 2019/11/25 14:21
 */
@Service
public class AliyunService {

    @Autowired
    private OssConfig ossConfig;
    @Autowired
    private OssUtils ossUtils;

    public String upload(MultipartFile file) {
        try {
            if (file != null) {
                String filename = file.getOriginalFilename();
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    //注意:要对新建的文件对象,关联一个输出流对象
                    FileOutputStream fos = new FileOutputStream(newFile);
                    fos.write(file.getBytes());
                    fos.close();

                    //把源文件里的内容复制到目标文件中
                    file.transferTo(newFile);
                    String path = ossUtils.upload(newFile);
                    System.out.println("path="+path);
                    String prefix = ossConfig.getUrlPrefix();
                    String imgUrl=prefix+path;
                    return imgUrl;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
