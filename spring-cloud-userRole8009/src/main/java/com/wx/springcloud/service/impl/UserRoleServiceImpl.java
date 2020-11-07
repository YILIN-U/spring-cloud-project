package com.wx.springcloud.service.impl;


import com.wx.springcloud.mapper.UserRoleMapper;
import com.wx.springcloud.model.UserRoleModel;
import com.wx.springcloud.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    //    新增用户角色信息
    @Override
    public int userRoleAdd(UserRoleModel userRoleModel) {
        return userRoleMapper.userRoleAdd(userRoleModel);
    }

    //    根据userCode得到角色信息
    @Override
    public List<UserRoleModel> getRoleByUserCode(String userCode) {
        return userRoleMapper.getRoleByUserCode(userCode);
    }

    //    删除用户相关的角色数据
    @Override
    public int rolePerDelete(String roleCode) {
        return userRoleMapper.rolePerDelete(roleCode);
    }
}
