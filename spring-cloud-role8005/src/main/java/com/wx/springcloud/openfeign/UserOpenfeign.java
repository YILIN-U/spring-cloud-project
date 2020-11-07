package com.wx.springcloud.openfeign;

import com.wx.springcloud.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient("USER-SERVER")
public interface UserOpenfeign {

    @GetMapping("/user/getUserInfo")
    UserModel getUserInfo(@RequestParam("username") String username);

}
