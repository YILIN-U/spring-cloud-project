package com.wx.springcloud.controller;


import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.ReportModel;
import com.wx.springcloud.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dailyReport")
public class DailyReportController {
    @Autowired
    ReportService reportService;

    @PostMapping("/reportAdd")
    public CommonResult reportAdd(@RequestBody ReportModel reportModel) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        reportModel.setSubmitDate(simpleDateFormat.format(new Date()));
        int count = reportService.reportAdd(reportModel);
        return CommonResult.success(count);
    }

    @PutMapping("/reportUpdate")
    public CommonResult reportUpdate(@RequestBody ReportModel reportModel) {
        int Count = reportService.reportUpdate(reportModel);
        return CommonResult.success(Count);
    }

    @DeleteMapping("reportDelete/{id}")
    public CommonResult reportDelete(@PathVariable(value = "id") String id) {
        int count = reportService.reportDelete(id);
        return CommonResult.success(count);
    }


    @PostMapping("/getAllReport")
    public CommonResult getAllReport(@RequestBody(required = false) ReportModel reportModel) {
        List<ReportModel> list = reportService.getAllReport(reportModel);
        return CommonResult.success(list);
    }

    //    点击提交将草稿状态改为提交
    @PutMapping("/reportSubmit/{id}")
    public CommonResult reportSubmit(@PathVariable String id) {
        int Count = reportService.reportSubmit(id);
        return CommonResult.success(Count);
    }

    //通过Id找到日报的信息
    @GetMapping("/findReportById/{id}")
    public CommonResult findReportById(@PathVariable String id) {
        ReportModel reportModel = reportService.findReportById(id);
        return CommonResult.success(reportModel);
    }




}
