package com.wx.springcloud.mapper;

import com.wx.springcloud.model.GroupModel;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface GroupMapper {
    //    添加小组
    int groupAdd(GroupModel groupModel);

    // 检查小组是否存在
    GroupModel checkGroupIsExist(GroupModel model);

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

    //    检查更新的小组名是否存在
    GroupModel checkGroupName(GroupModel groupModel);
}
