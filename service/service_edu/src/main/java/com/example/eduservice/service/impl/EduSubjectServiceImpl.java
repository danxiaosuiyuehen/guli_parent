package com.example.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.eduservice.entity.EduSubject;
import com.example.eduservice.entity.Listener.readListener;
import com.example.eduservice.entity.excel.SubjectData;
import com.example.eduservice.entity.subject.OneLevelSubject;
import com.example.eduservice.entity.subject.TwoLevelSubject;
import com.example.eduservice.mapper.EduSubjectMapper;
import com.example.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author yu
 * @since 2021-05-08
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file,EduSubjectService eduSubjectService) {
        try {
            InputStream inputStream=file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class,new readListener(eduSubjectService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OneLevelSubject> getSubject() {
        List<OneLevelSubject> oneLevelSubjectList=new ArrayList<>();

        QueryWrapper<EduSubject> wrapper1=new QueryWrapper<>();
        wrapper1.eq("parent_id",0);
        List<EduSubject> eduSubjects1 = baseMapper.selectList(wrapper1);

        QueryWrapper<EduSubject> wrapper2=new QueryWrapper<>();
        wrapper2.ne("parent_id",0);
        List<EduSubject> eduSubjects2 = baseMapper.selectList(wrapper2);

        for(EduSubject eduSubject1:eduSubjects1){
            OneLevelSubject oneLevelSubject=new OneLevelSubject();
            BeanUtils.copyProperties(eduSubject1,oneLevelSubject);
            oneLevelSubjectList.add(oneLevelSubject);

            List<TwoLevelSubject> twoLevelSubjects=new ArrayList<>();
            for (EduSubject eduSubject2 : eduSubjects2) {
                TwoLevelSubject twoLevelSubject=new TwoLevelSubject();
                BeanUtils.copyProperties(eduSubject2,twoLevelSubject);
                if(eduSubject2.getParentId().equals(oneLevelSubject.getId())){
                    twoLevelSubjects.add(twoLevelSubject);
                }
            }
        oneLevelSubject.setChildren(twoLevelSubjects);
        }
        return oneLevelSubjectList;

    }

}
