package com.wx.springcloud.service.impl;


import com.wx.springcloud.mapper.ReportMapper;
import com.wx.springcloud.model.ReportModel;
import com.wx.springcloud.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportMapper reportMapper;

//    添加日报
    @Override
    public int reportAdd(ReportModel reportModel) {
        return reportMapper.reportAdd(reportModel);
    }

//    更新日报
    @Override
    public int reportUpdate(ReportModel reportModel) {
        return reportMapper.reportUpdate(reportModel);
    }

//    删除日报
    @Override
    public int reportDelete(String id) {
        return reportMapper.reportDelete(id);
    }

//    得到所有日报
    @Override
    public List<ReportModel> getAllReport(ReportModel reportModel) {
        return reportMapper.getAllReport(reportModel);
    }

//     点击提交将草稿状态改为提交
    @Override
    public int reportSubmit(String id) {
        return reportMapper.reportSubmit(id);
    }

    @Override
    public ReportModel findReportById(String id) {
        return reportMapper.findReportById(id);
    }
}
