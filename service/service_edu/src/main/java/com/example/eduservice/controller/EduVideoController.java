package com.example.eduservice.controller;


import com.example.eduservice.client.VodClient;
import com.example.eduservice.entity.EduVideo;
import com.example.eduservice.service.EduVideoService;
import com.example.utils.R;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author yu
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/eduservice/edu-video")
@CrossOrigin
public class EduVideoController {
    @Resource
    private EduVideoService eduVideoService;
    @Resource
    private VodClient vodClient;
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
    eduVideoService.save(eduVideo);
    return R.ok();
    }
    @DeleteMapping("deleteVideo/{videoId}")
    public R deleteVideo(@PathVariable String videoId){
        EduVideo eduVideo = eduVideoService.getById(videoId);
        String videoSourceId = eduVideo.getVideoSourceId();
        if(!StringUtils.isEmpty(videoSourceId)){vodClient.deleteVodById(videoSourceId);}
        eduVideoService.removeById(videoId);
        return R.ok();
    }
    @GetMapping("selectVideo/{videoId}")
    public R selectVideo(@PathVariable String videoId){
        EduVideo eduVideo = eduVideoService.getById(videoId);
        return R.ok().data("eduVideo",eduVideo);
    }
    @PostMapping("updateVideo")
    public R updateVideo(@RequestBody EduVideo eduVideo){
        eduVideoService.updateById(eduVideo);
        return R.ok();
    }


}

