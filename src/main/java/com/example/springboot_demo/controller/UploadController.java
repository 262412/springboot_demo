package com.example.springboot_demo.controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.springboot_demo.pojo.Result;
import com.example.springboot_demo.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping
    public Result upload(MultipartFile image) throws IOException, ClientException {
        log.info("文件上传开始，上传的文件为：{}", image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);// 获取上传成功后返回的url
        log.info("文件上传完成,文件访问的url为：{}",url);
        return Result.success(url);
    }

}
