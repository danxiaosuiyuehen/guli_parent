package com.example.eduservice.service;

import com.example.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.eduservice.entity.subject.OneLevelSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author yu
 * @since 2021-05-08
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file,EduSubjectService eduSubjectService);

    List<OneLevelSubject> getSubject();
}
