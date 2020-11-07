package com.wx.springcloud.service;

import com.wx.springcloud.model.ReportModel;

import java.util.List;

public interface ReportService {
    int reportAdd(ReportModel reportModel);

    int reportUpdate(ReportModel reportModel);

    int reportDelete(String id);

    List<ReportModel> getAllReport(ReportModel reportModel);

    //    点击提交将草稿状态改为提交
    int reportSubmit(String id);

    ReportModel findReportById(String id);
}
