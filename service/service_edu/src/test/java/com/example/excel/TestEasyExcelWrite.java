package com.example.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestEasyExcelWrite {
    public static void main(String[] args) {
        String Filename="C:\\Users\\Administrator\\Desktop\\write.xlsx";
        EasyExcel.write(Filename,excelDate.class).sheet("学生信息").doWrite(doWrite());
    }
    public static List<excelDate> doWrite(){
        List<excelDate> list=new ArrayList<>();
        for (int i=0;i<10 ;i++){
            excelDate date=new excelDate();
            date.setSno(i);
            date.setSname("wy"+i);
            list.add(date);
        }
        return list;
    }
}
