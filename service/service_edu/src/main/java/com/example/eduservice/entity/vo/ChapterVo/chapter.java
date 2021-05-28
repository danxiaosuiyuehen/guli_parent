package com.example.eduservice.entity.vo.ChapterVo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class chapter {
    private String id;
    private String title;
    private List<video> children=new ArrayList<>();
}
