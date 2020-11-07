package com.wx.springcloud.controller;


import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.GroupUserModel;
import com.wx.springcloud.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groupUser")
public class GroupUserController {
    @Autowired
    GroupUserService groupUserService;

    @PostMapping("/groupMemberAdd")
    public CommonResult groupMemberAdd(@RequestBody GroupUserModel groupUserModel){
        int count=groupUserService.groupMemberAdd(groupUserModel);
        return CommonResult.success(count);
    }

//    将用户移出小组
    @DeleteMapping("/delGroupUser")
    public CommonResult delGroupUser(@RequestBody GroupUserModel groupUserModel){
        int count=groupUserService.delGroupUser(groupUserModel);
        return CommonResult.success(count);
    }

    //    删除小组中的所有成员
    @DeleteMapping("/groupUserDelAll")
    public CommonResult groupUserDelAll(@RequestBody GroupUserModel groupUserModel){
        int count=groupUserService.groupUserDelAll(groupUserModel);
        return CommonResult.success(count);
    }


}
