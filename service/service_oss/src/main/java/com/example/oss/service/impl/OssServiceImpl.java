package com.example.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.example.oss.utils.constantPropertiesUtils;
import com.example.oss.service.OssService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadOssFileAvatar(MultipartFile file) {
        String endpoint = constantPropertiesUtils.END_POINT;
        String accessKeyId =constantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = constantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName=constantPropertiesUtils.BUCKET_NAME;
        try{
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            InputStream inputStream=file.getInputStream();

            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String fileName=file.getOriginalFilename();
            fileName=uuid+fileName;
            String datePath = new DateTime().toString("yyyy/MM/dd");
            fileName=datePath+"/"+fileName;
            ossClient.putObject(bucketName,fileName,inputStream);
            ossClient.shutdown();
            String url="https://"+bucketName+"."+endpoint+"/"+fileName;
            return url;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
