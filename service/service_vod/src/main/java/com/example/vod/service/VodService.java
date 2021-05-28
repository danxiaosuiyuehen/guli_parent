package com.example.vod.service;

import org.springframework.web.multipart.MultipartFile;

public interface VodService {
    String UploadVideo(MultipartFile file);

    void deleteVodById(String id);
}
