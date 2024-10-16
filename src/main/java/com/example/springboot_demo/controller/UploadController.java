package com.example.springboot_demo.controller;

import com.example.springboot_demo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传开始，上传的文件为：{}, {}, {}", username, age, image);
        return Result.success();
    }

}
