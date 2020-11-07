package com.wx.springcloud.mapper;


import com.wx.springcloud.model.CodeModel;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface CodeMapper {
    //    从码表中得到所有的学历信息
    List<CodeModel> getAllEducation();

    //    从码表中得到所有的专业信息
    List<CodeModel> getAllMajor();

    //    得到学历的value值
    CodeModel getEducationValue(String codeKey);

    //   得到所有的日报状态
    List<CodeModel> getAllReportStatus();

    //    得到日报状态的value值
    CodeModel getValueByStatus(String codeKey);


    //    得到日报为查看的状态信息
    List<CodeModel> getCheckStatus();

    //查询所有的点到状态
    List<CodeModel> getCheckPresence();

    // 得到考勤的value值
    String getCheckPresenceValue(String record);
}
