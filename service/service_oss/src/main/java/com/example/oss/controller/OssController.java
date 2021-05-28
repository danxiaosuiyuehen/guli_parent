package com.example.oss.controller;

import com.example.oss.service.OssService;
import com.example.utils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("eduoss/fileoss")
@CrossOrigin
public class OssController {
    @Resource
    private OssService ossService;
    @PostMapping
    public R uploadOssFile(MultipartFile file){
        String url=ossService.uploadOssFileAvatar(file);
        return R.ok().data("url",url);
    }
}


