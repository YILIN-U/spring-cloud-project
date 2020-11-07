package com.wx.springcloud.service;



import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.PermissionModel;

import java.util.List;

public interface PermissionService {

//    增加权限
    int permissionAdd(PermissionModel permissionModel);

//    更新权限信息
    int permissionUpdate(PermissionModel permissionModel);

//    删除权限信息
    int permissionDelete(String id);

//    得到所有所有权限
    List<PermissionModel> getAllPermission(PermissionModel permissionModel);

//    根据id找到编辑的数据
    CommonResult findPermissionById(PermissionModel permissionModel);
}
