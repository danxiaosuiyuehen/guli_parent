package com.example.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.eduservice.entity.EduChapter;
import com.example.eduservice.entity.EduVideo;
import com.example.eduservice.entity.vo.ChapterVo.chapter;
import com.example.eduservice.entity.vo.ChapterVo.video;
import com.example.eduservice.mapper.EduChapterMapper;
import com.example.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.eduservice.service.EduVideoService;
import com.example.servicebase.config.exceptionhandler.MyException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {
    @Resource
    private EduVideoService eduVideoService;
    @Override
    public List<chapter> queryChapterVideo(String courseId) {
        QueryWrapper<EduChapter> wrapper1=new QueryWrapper<>();
        wrapper1.eq("course_id",courseId);
        List<EduChapter> eduChapters = baseMapper.selectList(wrapper1);

        QueryWrapper<EduVideo> wrapper2=new QueryWrapper<>();
        wrapper2.eq("course_id",courseId);
        List<EduVideo> eduVideos = eduVideoService.list(wrapper2);

        List<chapter> list1=new ArrayList<>();
        for (EduChapter eduChapter:eduChapters) {
            chapter chapter=new chapter();
            BeanUtils.copyProperties(eduChapter,chapter);
            list1.add(chapter);

            List<video> list2=new ArrayList<>();
            for (EduVideo eduVideo:eduVideos) {
                if(eduChapter.getId().equals(eduVideo.getChapterId())){
                    video video=new video();
                    BeanUtils.copyProperties(eduVideo,video);
                    list2.add(video);
                }
            }
            chapter.setChildren(list2);
        }
        return list1;
    }

    @Override
    public Boolean deleteChapter(String chapterId) {
        QueryWrapper<EduVideo> wrapper=new QueryWrapper<>();
        wrapper.eq("chapter_Id",chapterId);
        int count = eduVideoService.count(wrapper);
        if(count>0) {
            throw new MyException(20001,"该章节存在小结，无法删除");
        }else {
            baseMapper.deleteById(chapterId);
        }
        return count==0;
    }

    @Override
    public void deleteChapterForAllInfo(String courseId) {
        QueryWrapper<EduChapter> wrapper=new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        baseMapper.delete(wrapper);
    }
}
