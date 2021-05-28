package com.example.vod.controller;

import com.example.utils.R;
import com.example.vod.service.VodService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("eduvod/video")
@CrossOrigin
public class VodController {
    @Resource
    private VodService vodService;
    @PostMapping("UploadVideo")
    public R UploadVideo(MultipartFile file){
        String id=vodService.UploadVideo(file);
        return R.ok().data("id",id);
    }
    @DeleteMapping("deleteVodById/{id}")
    public R deleteVodById(@PathVariable String id){
            vodService.deleteVodById(id);
            return R.ok();
    }
}
