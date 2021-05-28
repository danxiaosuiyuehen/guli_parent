package com.example.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.eduservice.entity.EduSubject;
import com.example.eduservice.entity.subject.OneLevelSubject;
import com.example.eduservice.service.EduSubjectService;
import com.example.utils.R;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author yu
 * @since 2021-05-08
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {
    @Resource
    private EduSubjectService eduSubjectService;
    @PostMapping("addSubject")
    public R  addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.error();
    }
    @GetMapping("selectSubject")
    public R selectSubject(){
        List<OneLevelSubject> list = eduSubjectService.getSubject();
        return R.ok().data("list",list);
    }

}

