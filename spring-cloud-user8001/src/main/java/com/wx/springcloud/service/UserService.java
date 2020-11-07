package com.wx.springcloud.service;



import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.UserModel;
import com.wx.springcloud.vo.LoginParam;

import java.util.List;


public interface UserService {

//    登录验证生成token
    String userLogin(LoginParam loginParam);

//    通过username查询用户信息
    UserModel getUser(String username);

//    添加用户
    int addUser(UserModel userModel);

//  更新用户信息
    CommonResult updateUser(UserModel userModel);

//    删除用户
    int deleteUser(String id);

//    查看所有用户
    List<UserModel> getAllUser(UserModel userMode);

//    通过用户编号查询用户信息
    UserModel getUserByUserCode(String userCode);

//    找到角色为督导的所有用户
    List<UserModel> getUserByRoleSupervision();

//      找到角色为教练的所有用户
    List<UserModel> getUserByRoleCoach();

//      找到角色为学生的所有用户
    List<UserModel> getUserByRoleStudent(String groupCode);

//     得到学生通过分组编号
    List<UserModel> getUseByGroupCode(String groupCode);
}
