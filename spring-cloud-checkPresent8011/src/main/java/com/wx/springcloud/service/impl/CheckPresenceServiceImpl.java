package com.wx.springcloud.service.impl;


import com.wx.springcloud.mapper.CheckPresenceMapper;
import com.wx.springcloud.model.CheckPresenceModel;
import com.wx.springcloud.service.CheckPresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckPresenceServiceImpl implements CheckPresenceService {
    @Autowired
    CheckPresenceMapper checkPresenceMapper;

    //    增加考勤记录
    @Override
    public int checkPresenceAdd(CheckPresenceModel checkPresenceModel) {
        return checkPresenceMapper.checkPresenceAdd(checkPresenceModel);
    }

    //    得到所有的考勤信息
    @Override
    public List<CheckPresenceModel> getAllPresence(CheckPresenceModel checkPresenceModel) {
        return checkPresenceMapper.getAllPresence(checkPresenceModel);
    }


    //   删除考勤信息
    @Override
    public int checkPresenceDelete(String id) {
        return checkPresenceMapper.checkPresenceDelete(id);
    }
}
