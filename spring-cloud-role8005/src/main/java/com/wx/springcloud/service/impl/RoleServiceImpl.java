package com.wx.springcloud.service.impl;

import cn.hutool.core.lang.Assert;
import com.wx.springcloud.mapper.RoleMapper;
import com.wx.springcloud.model.RoleModel;
import com.wx.springcloud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

//    增加角色
    @Override
    public int roleAdd(RoleModel roleModel) {
        Assert.isTrue(roleMapper.checkRole(roleModel.getRoleCode())==null,"角色已存在");
        int count=roleMapper.roleAdd(roleModel);
        return count;
    }

//    更新角色信息
    @Override
    public int roleUpdate(RoleModel roleModel) {
        return roleMapper.roleUpdate(roleModel);
    }

//    删除角色
    @Override
    public int roleDelete(String id) {
        return roleMapper.roleDelete(id);
    }

    @Override
    public List<RoleModel> getAllRole(RoleModel roleModel) {
        return roleMapper.getAllRole(roleModel);
    }

    //    通过角色编号找到角色
    @Override
    public RoleModel getRoleByRoleCode(String roleCode) {
        return roleMapper.getRoleByRoleCode(roleCode);
    }


}
