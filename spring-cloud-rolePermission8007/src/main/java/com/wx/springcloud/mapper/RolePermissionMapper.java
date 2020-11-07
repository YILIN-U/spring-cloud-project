package com.wx.springcloud.mapper;

import com.wx.springcloud.model.RolePermissionModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolePermissionMapper {
    //    新增角色的权限数据
    int rolePerAdd(RolePermissionModel rolePermissionModel);
    //    通过角色编号查询权限
    List<RolePermissionModel> getPermissionByRoleCode(String roleCode);

    //    删除角色的权限数据
    int rolePerDelete(String roleCode);
}
