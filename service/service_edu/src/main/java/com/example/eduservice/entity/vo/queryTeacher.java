package com.example.eduservice.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class queryTeacher {
    private String name;
    private Integer level;
    private Date begin;
    private Date end;
}
