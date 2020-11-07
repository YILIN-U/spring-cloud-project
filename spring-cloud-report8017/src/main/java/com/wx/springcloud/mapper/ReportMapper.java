package com.wx.springcloud.mapper;


import com.wx.springcloud.model.ReportModel;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface ReportMapper {
    int reportAdd(ReportModel reportModel);

    int reportUpdate(ReportModel reportModel);

    int reportDelete(String id);

    List<ReportModel> getAllReport(ReportModel reportModel);

    //     点击提交将草稿状态改为提交
    int reportSubmit(String id);

//
    ReportModel findReportById(String id);
}
