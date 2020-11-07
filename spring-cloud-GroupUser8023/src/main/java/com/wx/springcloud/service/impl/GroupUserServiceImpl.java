package com.wx.springcloud.service.impl;


import com.wx.springcloud.mapper.GroupUserMapper;
import com.wx.springcloud.model.GroupUserModel;
import com.wx.springcloud.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupUserServiceImpl implements GroupUserService {
    @Autowired
    GroupUserMapper groupUserMapper;

//   将成员分组
    @Override
    public int groupMemberAdd(GroupUserModel groupUserModel) {
        return groupUserMapper.groupMemberAdd(groupUserModel);
    }

    //   将用户移出小组
    @Override
    public int delGroupUser(GroupUserModel groupUserModel) {
        return groupUserMapper.delGroupUser(groupUserModel);
    }

    //    删除小组中的所有成员
    @Override
    public int groupUserDelAll(GroupUserModel groupUserModel) {
        return groupUserMapper.groupUserDelAll(groupUserModel);
    }


}
