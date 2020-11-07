package com.wx.springcloud.service;

import com.wx.springcloud.model.GroupModel;

import java.util.List;

public interface GroupService {

//    添加小组
    int groupAdd(GroupModel groupModel);

//    查询所有的小组
    List<GroupModel> groupAll(GroupModel groupModel);

    //    更新小组的成员数量
    int updateMemberCount(GroupModel groupModel);

    //    减少小组的成员数量
    int fillBackMemberCount(GroupModel groupModel);

    //    得到成员数量
    int getMemberCount(String groupCode);

//    小组删除
    int groupDelete(String groupCode);

    //    通过小组标号找到所要编辑的数据
    GroupModel findGroupByCode(String groupCode);


    //    更新小组信息
    int groupEdit(GroupModel groupModel);
}
