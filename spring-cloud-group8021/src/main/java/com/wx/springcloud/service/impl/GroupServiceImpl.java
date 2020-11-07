package com.wx.springcloud.service.impl;

import com.wx.springcloud.mapper.GroupMapper;
import com.wx.springcloud.model.GroupModel;
import com.wx.springcloud.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupMapper groupMapper;

//    添加小组
    @Override
    public int groupAdd(GroupModel groupModel) {
        int count=0;
        if (checkGroupIsExist(groupModel)){
            count=groupMapper.groupAdd(groupModel);
        }
        return count;
    }



    // 检查小组是否存在
    private boolean checkGroupIsExist(GroupModel model){
        GroupModel IsExist=groupMapper.checkGroupIsExist(model);
        return IsExist==null;

    }

        //    查询所有的小组
    @Override
    public List<GroupModel> groupAll(GroupModel groupModel) {
        return groupMapper.groupAll(groupModel);
    }

    //    更新小组的成员数量
    @Override
    public int updateMemberCount(GroupModel groupModel) {
        return groupMapper.updateMemberCount(groupModel);
    }

    //    减少小组的成员数量
    @Override
    public int fillBackMemberCount(GroupModel groupModel) {
        return groupMapper.fillBackMemberCount(groupModel);
    }

    //    得到成员数量
    @Override
    public int getMemberCount(String groupCode) {
        return groupMapper.getMemberCount(groupCode);
    }

    //    小组删除
    @Override
    public int groupDelete(String groupCode) {
        return groupMapper.groupDelete(groupCode);
    }

    //    通过小组标号找到所要编辑的数据
    @Override
    public GroupModel findGroupByCode(String groupCode) {
        return groupMapper.findGroupByCode(groupCode);
    }

    //    更新小组信息
    @Override
    public int groupEdit(GroupModel groupModel) {
        int count=0;
        if (checkGroupName(groupModel)){
            count=groupMapper.groupEdit(groupModel);
        }else{
            count=-1;
        }
        return count;
    }

//    检查更新的小组名是否存在
    private boolean checkGroupName(GroupModel model){

        GroupModel groupModel=groupMapper.checkGroupName(model);

        return groupModel==null;
    }
}
