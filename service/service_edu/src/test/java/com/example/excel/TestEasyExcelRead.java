package com.example.excel;

import com.alibaba.excel.EasyExcel;

public class TestEasyExcelRead {
    public static void main(String[] args) {
        String Filename="C:\\Users\\Administrator\\Desktop\\write.xlsx";
        EasyExcel.read(Filename,excelDate.class,new excelListener()).sheet().doRead();
    }
}
