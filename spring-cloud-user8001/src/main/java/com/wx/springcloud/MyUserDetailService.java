package com.wx.springcloud;


import com.wx.springcloud.model.UserModel;
import com.wx.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user=userService.getUser(username);
        return user;
    }

    public UserModel getUserInfo(String usernme){
        UserModel userModel=userService.getUser(usernme);
        return  userModel;
    }

}
