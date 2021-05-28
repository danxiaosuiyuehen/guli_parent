package com.example.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseInfoVo {
   private String     id ;
   private String     teacherId;
   private String     subjectId;
   private String subjectParentId;
   private String     title;
   private BigDecimal price;
   private Integer    lessonNum ;
   private String     cover;
   private String     description;
}
