package com.wx.springcloud.service.impl;


import com.wx.springcloud.mapper.CodeMapper;
import com.wx.springcloud.model.CodeModel;
import com.wx.springcloud.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    CodeMapper codeMapper;

    //    从码表中得到所有的学历信息
    @Override
    public List<CodeModel> getAllEducation() {
        return codeMapper.getAllEducation();
    }

    //    从码表中得到所有的专业信息
    @Override
    public List<CodeModel> getAllMajor() {
        return codeMapper.getAllMajor();
    }

    //   得到所有的日报状态
    @Override
    public List<CodeModel> getAllReportStatus() {
        return codeMapper.getAllReportStatus();
    }

    //    得到学历的value值
    @Override
    public CodeModel getEducationValue(String codeKey) {
        return codeMapper.getEducationValue(codeKey);
    }

    //    得到日报状态的value值
    @Override
    public CodeModel getValueByStatus(String codeKey) {
        return codeMapper.getValueByStatus(codeKey);
    }

    //    得到日报为查看的状态信息
    @Override
    public List<CodeModel> getCheckStatus() {
        return codeMapper.getCheckStatus();
    }

    //查询所有的点到状态
    @Override
    public List<CodeModel> getCheckPresence() {
        return codeMapper.getCheckPresence();
    }
    // 得到考勤的value值
    @Override
    public String getCheckPresenceValue(String record) {
        return codeMapper.getCheckPresenceValue(record);
    }
}
