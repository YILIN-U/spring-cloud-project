package com.wx.springcloud.mapper;


import com.wx.springcloud.model.CheckPresenceModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface CheckPresenceMapper {

    //    增加考勤记录
    int checkPresenceAdd(CheckPresenceModel checkPresenceModel);

    //    得到所有的考勤信息
    List<CheckPresenceModel> getAllPresence(CheckPresenceModel checkPresenceModel);

    //   删除考勤信息
    int checkPresenceDelete(String id);
}
