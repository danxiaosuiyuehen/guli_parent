package com.example.eduservice.service;

import com.example.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.eduservice.entity.vo.CourseInfoVo;
import com.example.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author yu
 * @since 2021-05-09
 */
public interface EduCourseService extends IService<EduCourse> {

    String addCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo selectCourse(String id);


    void updateCourse(CourseInfoVo courseInfoVo);


    CoursePublishVo selectAll(String courseId);

    void deleteCourseForAllInfo(String courseId);
}
