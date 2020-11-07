package com.wx.springcloud.controller;


import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.GroupModel;
import com.wx.springcloud.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping("/groupAdd")
    public CommonResult groupAdd(@RequestBody GroupModel groupModel){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        groupModel.setCreateTime(simpleDateFormat.format(new Date()));
        int count=groupService.groupAdd(groupModel);
        return CommonResult.success(count);
    }

    @PostMapping("/groupAll")
    public CommonResult groupAll(@RequestBody(required = false) GroupModel groupModel){
        List<GroupModel> list=groupService.groupAll(groupModel);
        return CommonResult.success(list);
    }

//    更新小组的成员数量
    @PutMapping("/updateMemberCount")
    public CommonResult updateMemberCount(@RequestBody GroupModel groupModel){
        int count=groupService.updateMemberCount(groupModel);
        return CommonResult.success(count);

    }

    //    减少小组的成员数量
    @PutMapping("/fillBackMemberCount")
    public CommonResult fillBackMemberCount(@RequestBody GroupModel groupModel){
        int count=groupService.fillBackMemberCount(groupModel);
        return CommonResult.success(count);
    }

//    得到成员数量
    @GetMapping("/getMemberCount/{groupCode}")
    public CommonResult getMemberCount(@PathVariable("groupCode") String groupCode){
        int count=groupService.getMemberCount(groupCode);
        return CommonResult.success(count);
    }

//小组删除
    @DeleteMapping("/groupDel/{groupCode}")
    public CommonResult groupDel(@PathVariable("groupCode") String groupCode){
        int count=groupService.groupDelete(groupCode);
        return CommonResult.success(count);
    }

//    通过小组标号找到所要编辑的数据
    @GetMapping("/findGroupByCode/{groupCode}")
    public CommonResult findGroupByCode(@PathVariable("groupCode") String groupCode){
        GroupModel groupModel=groupService.findGroupByCode(groupCode);
        return CommonResult.success(groupModel);
    }

//    更新小组信息
    @PutMapping("/groupEdit")
    public CommonResult groupEdit(@RequestBody GroupModel groupModel){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        groupModel.setUpdateTime(simpleDateFormat.format(new Date()));
        int count=groupService.groupEdit(groupModel);
        return CommonResult.success(count);
    }





}
