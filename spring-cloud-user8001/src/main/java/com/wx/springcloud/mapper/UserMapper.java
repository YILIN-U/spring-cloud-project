package com.wx.springcloud.mapper;

import com.wx.springcloud.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

//    根据用户名,查询用户信息
    UserModel getUser(String username);

//    添加用户
    int addUser(UserModel userModel);

//    检查用户是否存在
    UserModel checkUser(String userCode);

//    更新用户信息
    int updateUser(UserModel userModel);

//    删除用户
    int deleteUser(String id);

//    查询所有用户
    List<UserModel> getAllUser(UserModel userModel);

//    记录登录失败次数
    void addFailLoginCount(UserModel user);

//    冻结用户
    String freezeAccount(Integer id);

    //    通过用户编号查询用户信息
    UserModel getUserByUserCode(String userCode);

    //    找到角色为督导的所有用户
    List<UserModel> getUserByRoleSupervision();

    //      找到角色为教练的所有用户
    List<UserModel> getUserByRoleCoach();
    //      找到角色为学生的所有用户
    List<UserModel> getUserByRoleStudent(String groupCode);

//    得到学生通过分组编号
    List<UserModel> getUseByGroupCode(String groupCode);
}
