package com.wx.springcloud.controller;



import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.UserRoleModel;
import com.wx.springcloud.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @PostMapping("/userRoleAdd")
    public CommonResult userRoleAdd(@RequestBody UserRoleModel userRoleModel){

        //       处理权限数据
        String role = userRoleModel.getRoleCode().replace("[", "").replace("]", "");
        role = role.replace("\"", "");
        String[] roleArray = role.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(roleArray));
        userRoleModel.setRoleCodes(list);

        int count=userRoleService.userRoleAdd(userRoleModel);

        return CommonResult.success(count);

    }

    //    根据userCode得到角色信息
    @PostMapping("/getRoleByUserCode/{userCode}")
    public CommonResult getRoleByUserCode(@PathVariable("userCode") String userCode) {
        List<UserRoleModel> list = userRoleService.getRoleByUserCode(userCode);
        return CommonResult.success(list);
    }

    //    删除数据
    @DeleteMapping("/userRoleDelete/{userCode}")
    public CommonResult userRoleDelete(@PathVariable("userCode") String roleCode){
        int count=userRoleService.rolePerDelete(roleCode);
        return CommonResult.success(count);
    }



}
