package com.wx.springcloud.service;

import com.wx.springcloud.model.RoleModel;

import java.util.List;

public interface RoleService {
//    增加角色
    int roleAdd(RoleModel roleModel);

//    角色更新
    int roleUpdate(RoleModel roleModel);

//    删除角色
    int roleDelete(String id);

//    获取所有的角色
    List<RoleModel> getAllRole(RoleModel roleModel);

//    通过角色编号找到角色
    RoleModel getRoleByRoleCode(String roleCode);
}
