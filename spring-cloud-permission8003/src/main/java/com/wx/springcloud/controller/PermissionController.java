package com.wx.springcloud.controller;


import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.PermissionModel;
import com.wx.springcloud.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    RestTemplate restTemplate;


    @Autowired
    PermissionService permissionService;

    @PostMapping("/permissionAdd")
    public CommonResult permissionAdd(@RequestBody PermissionModel permissionModel){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        permissionModel.setCreateTime(simpleDateFormat.format(new Date()));
        int count=permissionService.permissionAdd(permissionModel);
        return CommonResult.success(count);
    }

    @PutMapping("/permissionUpdate")
    public CommonResult permissionUpdate(@RequestBody PermissionModel permissionModel){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        permissionModel.setUpdateTime(simpleDateFormat.format(new Date()));
        int count=permissionService.permissionUpdate(permissionModel);
        return CommonResult.success(count);
    }

    @DeleteMapping("/permissionDelete/{id}")
    public CommonResult permissionDelete(@PathVariable("id") String id){
        int count=permissionService.permissionDelete(id);
        return CommonResult.success(count);
    }


    @PostMapping("/getAllPermission")
    public CommonResult getAllPermission(@RequestBody(required = false) PermissionModel permissionModel){
        List<PermissionModel> list=permissionService.getAllPermission(permissionModel);
        return CommonResult.success(list);
    }

    @PostMapping("/findPermissionById")
    public CommonResult findPermissionById(@RequestBody PermissionModel permissionModel){
        try{
            return permissionService.findPermissionById(permissionModel);
        }catch (Exception e){
            return CommonResult.validateFailed("数据查询失败");
        }
    }


}
