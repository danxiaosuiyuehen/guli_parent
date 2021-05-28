package com.example.eduservice.service;

import com.example.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.eduservice.entity.vo.ChapterVo.chapter;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author yu
 * @since 2021-05-09
 */
public interface EduChapterService extends IService<EduChapter> {

    List<chapter> queryChapterVideo(String courseId);

    Boolean deleteChapter(String chapterId);

    void deleteChapterForAllInfo(String courseId);
}
