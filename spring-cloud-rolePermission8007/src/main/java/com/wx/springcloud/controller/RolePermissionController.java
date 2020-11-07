package com.wx.springcloud.controller;

import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.RolePermissionModel;
import com.wx.springcloud.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rolePermission")
public class RolePermissionController {
    @Autowired
    RolePermissionService rolePermissionService;

    @PostMapping("/rolePerAdd")
    public CommonResult rolePerAdd(@RequestBody RolePermissionModel rolePermissionModel) {

//       处理权限数据
        String permission = rolePermissionModel.getPermissionCode().replace("[", "").replace("]", "");
        permission = permission.replace("\"", "");
        String[] permissionArray = permission.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(permissionArray));
        rolePermissionModel.setPermissionCodes(list);

//       增加数据
        int count = rolePermissionService.rolePerAdd(rolePermissionModel);
        return CommonResult.success(count);
    }

    //    根据RoleCode得到权限信息
    @PostMapping("/getPermissionByRoleCode/{roleCode}")
    public CommonResult getPermissionByRoleCode(@PathVariable("roleCode") String roleCode) {
        List<RolePermissionModel> list = rolePermissionService.getPermissionByRoleCode(roleCode);
        return CommonResult.success(list);
    }

//    删除数据

    @DeleteMapping("/rolePerDelete/{roleCode}")
    public CommonResult rolePerDelete(@PathVariable("roleCode") String roleCode){
        int count=rolePermissionService.rolePerDelete(roleCode);
        return CommonResult.success(count);
    }



}
