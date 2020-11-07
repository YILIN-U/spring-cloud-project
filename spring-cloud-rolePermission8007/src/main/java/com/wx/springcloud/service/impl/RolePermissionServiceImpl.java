package com.wx.springcloud.service.impl;



import com.wx.springcloud.mapper.RolePermissionMapper;
import com.wx.springcloud.model.RolePermissionModel;
import com.wx.springcloud.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    //    新增角色的权限数据
    @Override
    public int rolePerAdd(RolePermissionModel rolePermissionModel) {
        return rolePermissionMapper.rolePerAdd(rolePermissionModel);
    }

//    通过角色编号查询权限
    @Override
    public List<RolePermissionModel> getPermissionByRoleCode(String roleCode) {
        return rolePermissionMapper.getPermissionByRoleCode(roleCode);
    }

    //    删除角色的权限数据
    @Override
    public int rolePerDelete(String roleCode) {
        return rolePermissionMapper.rolePerDelete(roleCode);
    }
}
