package com.wx.springcloud.mapper;

import com.wx.springcloud.model.RoleModel;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface RoleMapper {
//    检查用户是否存在
    RoleModel checkRole(String roleCode);

//    添加角色
    int roleAdd(RoleModel roleModel);

//    更新角色信息
    int roleUpdate(RoleModel roleModel);

//    删除角色
    int roleDelete(String id);

// 得到所有角色
    List<RoleModel> getAllRole(RoleModel roleModel);

  //    通过角色编号找到角色
    RoleModel getRoleByRoleCode(String roleCode);
}
