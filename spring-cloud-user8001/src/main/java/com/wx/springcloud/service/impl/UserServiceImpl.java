package com.wx.springcloud.service.impl;

import com.wx.springcloud.MyUserDetailService;
import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.mapper.UserMapper;
import com.wx.springcloud.model.UserModel;
import com.wx.springcloud.service.UserService;
import com.wx.springcloud.util.JwtTokenUtil;
import com.wx.springcloud.vo.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Autowired
    MyUserDetailService myUserDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenUtil jwtTokenUtil;


//    生成token
    @Override
    public String userLogin(LoginParam loginParam) {
        String token=null;
            try {
                 UserModel user = (UserModel) myUserDetailService.loadUserByUsername(loginParam.getUsername());
                if (!passwordEncoder.matches(loginParam.getPassword(), user.getPassword())) {
                    int loginFailureCount=user.getLoginFailureCount();
                    if (loginFailureCount>=3){
                        return userMapper.freezeAccount(user.getId());
                    }
                    user.setLoginFailureCount(loginFailureCount+1);
                    userMapper.addFailLoginCount(user);
                    throw new BadCredentialsException("密码不正确");
                }
                token = jwtTokenUtil.generateToken(user);
            } catch (Exception ignored) {
            }

        return token;
    }

//    从数据库中查询的用户信息,包括账号密码等
    @Override
    public UserModel getUser(String username) {
        return userMapper.getUser(username);
    }

//    增添用户
    @Override
    public int addUser(UserModel userModel) {

        int count=0;

        if (!checkUser(userModel.getUserCode())){
            count=userMapper.addUser(userModel);
        }

        return count;
    }

    //    检查用户是否存在
    private boolean checkUser(String userCode){

        UserModel isHave=userMapper.checkUser(userCode);

        return isHave!=null;

    }

//    更新用户信息
    @Override
    public CommonResult updateUser(UserModel userModel) {
        if (!userModel.getPassword().equals("")){
            String password = userModel.getPassword();
            userModel.setPassword(passwordEncoder.encode(password));
        }
        int count=userMapper.updateUser(userModel);
        return CommonResult.success(count);
    }

//    删除用户
    @Override
    public int deleteUser(String id) {

        return userMapper.deleteUser(id);
    }

//   查询所有用户
    @Override
    public List<UserModel> getAllUser(UserModel userModel) {

        return userMapper.getAllUser(userModel);
    }

    //    通过用户编号查询用户信息
    @Override
    public UserModel getUserByUserCode(String userCode) {
        return userMapper.getUserByUserCode(userCode);
    }

    //    找到角色为督导的所有用户
    @Override
    public List<UserModel> getUserByRoleSupervision() {
        return userMapper.getUserByRoleSupervision();
    }

    //      找到角色为教练的所有用户
    @Override
    public List<UserModel> getUserByRoleCoach() {
        return userMapper.getUserByRoleCoach();
    }

    //      找到角色为学生的所有用户
    @Override
    public List<UserModel> getUserByRoleStudent(String groupCode) {
        return userMapper.getUserByRoleStudent(groupCode);
    }

//    得到学生通过分组编号
    @Override
    public List<UserModel> getUseByGroupCode(String groupCode) {
        return userMapper.getUseByGroupCode(groupCode);
    }


}
