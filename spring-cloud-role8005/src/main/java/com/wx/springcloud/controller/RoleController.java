package com.wx.springcloud.controller;

import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.RoleModel;
import com.wx.springcloud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("/roleAdd")
    public CommonResult roleAdd(@RequestBody RoleModel roleModel){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        roleModel.setCreateTime(simpleDateFormat.format(new Date()));
        int count=roleService.roleAdd(roleModel);
        return CommonResult.success(count);
    }

    @PutMapping("/roleUpdate")
    public CommonResult roleUpdate(@RequestBody RoleModel roleModel){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        roleModel.setUpdateTime(simpleDateFormat.format(new Date()));
        int count=roleService.roleUpdate(roleModel);
        return CommonResult.success(count);
    }

    @DeleteMapping("/roleDelete/{id}")
    public CommonResult roleDelete(@PathVariable("id") String id){
        int count=roleService.roleDelete(id);
        return CommonResult.success(count);
    }


    @PostMapping("/getAllRole")
    public CommonResult getAllRole(@RequestBody(required = false) RoleModel roleModel){
        List<RoleModel> list=roleService.getAllRole(roleModel);
        return CommonResult.success(list);
    }

    @GetMapping("/getRoleByRoleCode/{roleCode}")
    public CommonResult getRoleByRoleCode(@PathVariable("roleCode") String roleCode){
        RoleModel roleModel=roleService.getRoleByRoleCode(roleCode);
        return CommonResult.success(roleModel);
    }


}
