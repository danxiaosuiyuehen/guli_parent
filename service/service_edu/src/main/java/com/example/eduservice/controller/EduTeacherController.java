package com.example.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.eduservice.entity.EduTeacher;
import com.example.eduservice.entity.vo.queryTeacher;
import com.example.eduservice.service.EduTeacherService;
import com.example.utils.R;
import org.springframework.data.annotation.Id;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author yu
 * @since 2021-05-02
 */

@RestController
@RequestMapping("/eduservice/edu-teacher")
@CrossOrigin
public class EduTeacherController {
    @Resource
    private EduTeacherService eduTeacherService;

    @GetMapping("findAll")
    public R findAll(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return  R.ok().data("items", list);
    }
    @GetMapping("selectById/{id}")
    public R selectById(@PathVariable String id){
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return R.ok().data("eduTeacher",eduTeacher);
    }
    @DeleteMapping("{id}")
    public R deleteTeacher(@PathVariable String id){
        boolean b = eduTeacherService.removeById(id);
        if(b){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @PostMapping ("PageSelect/{current}/{limit}")
    public R PageSelect(@PathVariable Integer current,@PathVariable Integer limit,
                        @RequestBody(required = false) queryTeacher queryTeacher){
        Page<EduTeacher> page =new Page<>(current,limit) ;
        QueryWrapper<EduTeacher> wrapper=new QueryWrapper<>();

        String name = queryTeacher.getName();
        Integer level = queryTeacher.getLevel();
        Date begin = queryTeacher.getBegin();
        Date end = queryTeacher.getEnd();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create",end);
        }
        wrapper.orderByDesc("gmt_create");

        eduTeacherService.page(page,wrapper);

        List<EduTeacher> pageRecords = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("pageRecords",pageRecords).data("total",total);
    }

    @PostMapping("saveTeacher")
    public R saveTeacher(@RequestBody(required = false) EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if(save){return R.ok();}
        else {return R.error();}
    }
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean update = eduTeacherService.updateById(eduTeacher);
        if(update){return R.ok();}
        else {return R.error();}
    }
}


