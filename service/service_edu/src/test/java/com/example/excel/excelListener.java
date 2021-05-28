package com.example.excel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import java.util.Map;

public class excelListener extends AnalysisEventListener<excelDate> {

    @Override/*读行*/
    public void invoke(excelDate excelDate, AnalysisContext analysisContext) {
        System.out.println(excelDate);
    }

    @Override/*读表头*/
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println(headMap);
    }

    @Override/*读完做的事情*/
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }
}
