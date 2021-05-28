package com.example.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.eduservice.entity.EduCourse;
import com.example.eduservice.entity.vo.CourseInfoVo;
import com.example.eduservice.entity.vo.CoursePublishVo;
import com.example.eduservice.entity.vo.queryCourseVo;
import com.example.eduservice.service.EduCourseService;
import com.example.utils.R;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author yu
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/eduservice/edu-course")
@CrossOrigin
public class EduCourseController {
    @Resource
    private EduCourseService eduCourseService;
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody(required = false) CourseInfoVo courseInfoVo){
        String id=eduCourseService.addCourseInfo(courseInfoVo);
        return R.ok().data("id",id);
    }

    @GetMapping("queryCourse/{id}")
    public R queryCourse(@PathVariable String id){
        CourseInfoVo courseInfoVo=eduCourseService.selectCourse(id);
        return R.ok().data("courseInfoVo",courseInfoVo);
    }

    @PostMapping("updateCourse")
    public R updateCourse(@RequestBody(required = false) CourseInfoVo courseInfoVo){
        eduCourseService.updateCourse(courseInfoVo);
       return R.ok();
    }
    @GetMapping("selectAll/{courseId}")
    public R selectAll(@PathVariable String courseId){
        CoursePublishVo coursePublishVo=eduCourseService.selectAll(courseId);
        return R.ok().data("CoursePublishVo",coursePublishVo);
    }
    @PostMapping("updateStatus/{courseId}")
    public R updateStatus(@PathVariable String courseId){
        EduCourse eduCourse=new EduCourse();
        eduCourse.setId(courseId);
        eduCourse.setStatus("Normal");
        eduCourseService.updateById(eduCourse);
        return R.ok();
    }
    @PostMapping("queryAllCourse/{current}/{limit}")
    public R queryAllCourse(@PathVariable Integer current, @PathVariable Integer limit,
                            @RequestBody(required = false)queryCourseVo queryCourseVo){
        QueryWrapper<EduCourse> wrapper =new QueryWrapper<>();
        String title = queryCourseVo.getTitle();
        String status = queryCourseVo.getStatus();
        if(!StringUtils.isEmpty(status)){
        wrapper.eq("status",status);
        }
        if(!StringUtils.isEmpty(title)){
            wrapper.like("title",title);
        }

        Page<EduCourse> page=new Page<>(current,limit);
        eduCourseService.page(page,wrapper);
        List<EduCourse> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("records",records).data("total",total);
    }
    @DeleteMapping("deleteCourseForAllInfo/{courseId}")
    public R deleteCourseForAllInfo(@PathVariable String courseId){
        eduCourseService.deleteCourseForAllInfo(courseId);
        return R.ok();
    }




}

