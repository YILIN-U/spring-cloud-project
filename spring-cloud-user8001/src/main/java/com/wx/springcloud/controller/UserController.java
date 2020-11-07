package com.wx.springcloud.controller;



import com.wx.springcloud.MyUserDetailService;
import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.UserModel;
import com.wx.springcloud.service.UserService;
import com.wx.springcloud.vo.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    MyUserDetailService myUserDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Value("${jwt.tokenHead}")
    String tokenHead;

    @PostMapping("/login")
    public CommonResult userLogin(@RequestBody LoginParam loginParam, HttpServletRequest request){
        HashMap<String, String> data = new HashMap<>();
        String token = null;
        try {
            token = userService.userLogin(loginParam);
            if (token!=null){
                request.getSession().setAttribute("username",loginParam.getUsername());
            }


        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.validateFailed("用户名或密码错误");
        }
        if (StringUtils.isEmpty(token)){
            return CommonResult.validateFailed("用户名或密码错误");
        }

        data.put("tokenHead",tokenHead);
        data.put("access_token",token);
        // localStorage.setItem("Authorization","Bearer sdsdfdfds")
        // $ajax{data:{},type:"",header:{"Authorization":"Bearer sdsdfdfds"}}
        return CommonResult.success(data);
    }

    @GetMapping("/management")
    public CommonResult getUserImfo(HttpServletRequest request){
        Object username = request.getSession().getAttribute("username");
        UserModel userModel=userService.getUser(username.toString());
        return CommonResult.success(userModel);
    }

    @PostMapping("/exitManagement")
    public CommonResult exitManagement(HttpServletRequest request){
        request.getSession().setAttribute("username",null);
        return CommonResult.success(null);
    }


    @PostMapping("/addUser")
    public CommonResult addUser(@RequestBody UserModel userModel){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        userModel.setCreateTime(simpleDateFormat.format(new Date()));
        String password = userModel.getPassword();
        userModel.setPassword(passwordEncoder.encode(password));
        int count=userService.addUser(userModel);
        return CommonResult.success(count);
    }

    @PutMapping("/updateUser")
    public CommonResult updateUser(@RequestBody UserModel userModel){

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        userModel.setUpdateTime(simpleDateFormat.format(new Date()));
        return userService.updateUser(userModel);
    }

    @DeleteMapping("/deleteUser/{id}")
    public CommonResult deleteUser(@PathVariable("id") String id){
        int count=userService.deleteUser(id);
        return CommonResult.success(count);
    }

    @PostMapping("/getAllUser")
    public CommonResult getAllUser(@RequestBody(required = false) UserModel userModel){
        List<UserModel> list=userService.getAllUser(userModel);
        return CommonResult.success(list);
    }

    @GetMapping("/getUserByUserCode/{userCode}")
    public CommonResult getUserByUserCode(@PathVariable("userCode") String userCode){
        UserModel userModel=userService.getUserByUserCode(userCode);
        return CommonResult.success(userModel);
    }

    @GetMapping("/getUserByRoleSupervision")
    public CommonResult getUserByRoleSupervision(){
        List<UserModel> list=userService.getUserByRoleSupervision();
        return CommonResult.success(list);
    }

    @GetMapping("/getUserByRoleCoach")
    public CommonResult getUserByRoleCoach(){
        List<UserModel> list=userService.getUserByRoleCoach();
        return CommonResult.success(list);
    }

    @GetMapping("/getUserByRoleStudent/{groupCode}")
    public CommonResult getUserByRoleStudent(@PathVariable String groupCode){
        List<UserModel> list=userService.getUserByRoleStudent(groupCode);
        return CommonResult.success(list);
    }


//    得到学生通过分组编号
    @GetMapping("/getUseByGroupCode/{groupCode}")
    public CommonResult getUseByGroupCode(@PathVariable String groupCode){
        List<UserModel> list=userService.getUseByGroupCode(groupCode);
        return CommonResult.success(list);
    }

    @GetMapping("/getUserInfo")
    public UserModel getUserInfo(@RequestParam("username") String username){
        UserModel userModel =myUserDetailService.getUserInfo(username);
        return userModel;
    }


}
