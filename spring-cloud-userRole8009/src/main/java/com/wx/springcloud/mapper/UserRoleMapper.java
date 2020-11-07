package com.wx.springcloud.mapper;

import com.wx.springcloud.model.UserRoleModel;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface UserRoleMapper {

    //    新增用户角色信息
    int userRoleAdd(UserRoleModel userRoleModel);

    //    根据userCode得到角色信息
    List<UserRoleModel> getRoleByUserCode(String userCode);

    //    删除用户相关的角色数据
    int rolePerDelete(String roleCode);
}
