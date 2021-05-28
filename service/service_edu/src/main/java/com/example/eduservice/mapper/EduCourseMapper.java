package com.example.eduservice.mapper;

import com.example.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author yu
 * @since 2021-05-09
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
     CoursePublishVo getAllInformationForPublish(String courseId);
}
