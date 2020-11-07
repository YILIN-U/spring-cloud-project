package com.wx.springcloud.service;



import com.wx.springcloud.model.CheckPresenceModel;

import java.util.List;

public interface CheckPresenceService {
//    增加考勤记录
    int checkPresenceAdd(CheckPresenceModel checkPresenceModel);

    //    得到所有的考勤信息
    List<CheckPresenceModel> getAllPresence(CheckPresenceModel checkPresenceModel);

    //   删除考勤信息
    int checkPresenceDelete(String id);
}
