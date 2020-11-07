package com.wx.springcloud.service.impl;

import cn.hutool.core.lang.Assert;
import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.mapper.PermissionMapper;
import com.wx.springcloud.model.PermissionModel;
import com.wx.springcloud.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public int permissionAdd(PermissionModel permissionModel) {
        Assert.isTrue(permissionMapper.checkPermission(permissionModel.getPermissionCode())==null,"权限已经存在");
        return permissionMapper.permissionAdd(permissionModel);
    }

    @Override
    public int permissionUpdate(PermissionModel permissionModel) {
        return permissionMapper.permissionUpdate(permissionModel);
    }

    @Override
    public int permissionDelete(String id) {
        return permissionMapper.permissionDelete(id);
    }

    @Override
    public List<PermissionModel> getAllPermission(PermissionModel permissionModel) {
        return permissionMapper.getAllPermission(permissionModel);
    }
    //    根据id找到编辑的数据
    @Override
    public CommonResult findPermissionById(PermissionModel permissionModel) {
        PermissionModel model=permissionMapper.findPermissionById(permissionModel);
        return CommonResult.success(model);
    }
}
