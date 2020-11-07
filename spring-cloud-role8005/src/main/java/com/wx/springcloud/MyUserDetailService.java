package com.wx.springcloud;

import com.wx.springcloud.model.UserModel;
import com.wx.springcloud.openfeign.UserOpenfeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserOpenfeign userOpenfeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel result=userOpenfeign.getUserInfo(username);
        return  result;
    }
}
