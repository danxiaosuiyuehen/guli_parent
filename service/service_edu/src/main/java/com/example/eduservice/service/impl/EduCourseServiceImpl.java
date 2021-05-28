package com.example.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.eduservice.entity.EduCourse;
import com.example.eduservice.entity.EduCourseDescription;
import com.example.eduservice.entity.EduVideo;
import com.example.eduservice.entity.vo.CourseInfoVo;
import com.example.eduservice.entity.vo.CoursePublishVo;
import com.example.eduservice.mapper.EduCourseMapper;
import com.example.eduservice.service.EduChapterService;
import com.example.eduservice.service.EduCourseDescriptionService;
import com.example.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.eduservice.service.EduVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author yu
 * @since 2021-05-09
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {
    @Resource
    private EduChapterService eduChapterService;
    @Resource
    private EduVideoService eduVideoService;
    @Resource
    private EduCourseMapper eduCourseMapper;
    @Resource
    private EduCourseDescriptionService eduCourseDescriptionService;
    @Override
    public String addCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse=new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        baseMapper.insert(eduCourse);

        EduCourseDescription eduCourseDescription=new EduCourseDescription();
        BeanUtils.copyProperties(courseInfoVo,eduCourseDescription);
        eduCourseDescription.setId(eduCourse.getId());
        eduCourseDescriptionService.save(eduCourseDescription);
        return eduCourse.getId();
    }

    @Override
    public CourseInfoVo selectCourse(String id) {
        CourseInfoVo courseInfoVo=new CourseInfoVo();
        EduCourse eduCourse = baseMapper.selectById(id);

        EduCourseDescription eduCourseDescription = eduCourseDescriptionService.getById(id);
        courseInfoVo.setDescription(eduCourseDescription.getDescription());
        BeanUtils.copyProperties(eduCourse,courseInfoVo);
        return courseInfoVo;
    }

    @Override
    public void updateCourse(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse=new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        baseMapper.updateById(eduCourse);

        EduCourseDescription eduCourseDescription=new EduCourseDescription();
        eduCourseDescription.setId(courseInfoVo.getId());
        eduCourseDescription.setDescription(courseInfoVo.getDescription());
        eduCourseDescriptionService.updateById(eduCourseDescription);
    }

    @Override
    public CoursePublishVo selectAll(String courseId) {
        CoursePublishVo allInformationForPublish = eduCourseMapper.getAllInformationForPublish(courseId);
        return allInformationForPublish;
    }

    @Override
    public void deleteCourseForAllInfo(String courseId) {
        eduVideoService.deleteVideoForAllInfo(courseId);
        eduChapterService.deleteChapterForAllInfo(courseId);
        eduCourseDescriptionService.removeById(courseId);
        baseMapper.deleteById(courseId);

    }


}
