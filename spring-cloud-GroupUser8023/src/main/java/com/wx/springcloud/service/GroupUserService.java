package com.wx.springcloud.service;


import com.wx.springcloud.model.GroupUserModel;

public interface GroupUserService {
//    将成员分组
    int groupMemberAdd(GroupUserModel groupUserModel);

//   将用户移出小组
    int delGroupUser(GroupUserModel groupUserModel);
    //    删除小组中的所有成员
    int groupUserDelAll(GroupUserModel groupUserModel);
}
