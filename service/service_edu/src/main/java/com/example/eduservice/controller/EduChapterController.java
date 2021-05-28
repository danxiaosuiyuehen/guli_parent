package com.example.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.eduservice.entity.EduChapter;
import com.example.eduservice.entity.vo.ChapterVo.chapter;
import com.example.eduservice.service.EduChapterService;

import com.example.utils.R;
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
@RequestMapping("/eduservice/edu-chapter")
@CrossOrigin
public class EduChapterController {
    @Resource
    private EduChapterService eduChapterService;

    @GetMapping("selectChapterVideo/{courseId}")
    public R selectChapterVideo(@PathVariable String courseId){
        List<chapter> list= eduChapterService.queryChapterVideo(courseId);
        return R.ok().data("list",list);
    }

    @PostMapping("addChapter")
    public R addChapter(@RequestBody(required = false) EduChapter eduChapter){
        eduChapterService.save(eduChapter);
        return R.ok();
    }
    @PostMapping("updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter){
        eduChapterService.updateById(eduChapter);
        return R.ok();
    }
    @GetMapping("selectChapter/{chapterId}")
    public R selectChapter(@PathVariable String chapterId){
        QueryWrapper<EduChapter> wrapper=new QueryWrapper<>();
        wrapper.eq("id",chapterId);
        EduChapter eduChapter = eduChapterService.getOne(wrapper);
        return R.ok().data("chapter",eduChapter);
    }
    @DeleteMapping("deleteChapter/{chapterId}")
    public R deleteChapter(@PathVariable String chapterId){
      Boolean result=  eduChapterService.deleteChapter(chapterId);
        return R.ok().data("result",result);
    }

}

