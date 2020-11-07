package com.wx.springcloud.mapper;


import com.wx.springcloud.model.GroupUserModel;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface GroupUserMapper {

    //   将成员分组
    int groupMemberAdd(GroupUserModel groupUserModel);

    //   将用户移出小组
    int delGroupUser(GroupUserModel groupUserModel);

    //    删除小组中的所有成员
    int groupUserDelAll(GroupUserModel groupUserModel);
}
