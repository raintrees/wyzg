package com.wyzg.controller;

import com.wyzg.common.enums.ExceptionEnums;
import com.wyzg.common.exceptions.WyzgException;
import com.wyzg.service.AliyunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author raintrees
 * @date 2019/11/25 14:03
 */

@Controller
public class AliyunController {
    
    @Autowired
    private AliyunService aliyunService;

    @GetMapping(value = "/")
    public String showUpload(){
        return "upLoad";
    }

    @PostMapping(value = "/uploadFile")
    public String upload(@RequestParam("file")MultipartFile file, Model model){

        String path=aliyunService.upload(file);
        if(path == null){
            throw new WyzgException(ExceptionEnums.UPLOAD_FAIL);
        }
        model.addAttribute("url",path);
        return "success";

    }

}
