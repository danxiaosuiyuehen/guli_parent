package com.example.eduservice.service;

import com.example.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author yu
 * @since 2021-05-09
 */
public interface EduVideoService extends IService<EduVideo> {

    void deleteVideoForAllInfo(String courseId);
}
