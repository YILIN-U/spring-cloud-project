package com.wx.springcloud.controller;


import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.FavorModel;
import com.wx.springcloud.service.FavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favor")
public class FavorController {

    @Autowired
    FavorService favorService;

    @PostMapping("/favorAdd")
    public CommonResult favorAdd(@RequestBody FavorModel favorModel){
        int count=favorService.favorAdd(favorModel);
        return CommonResult.success(count);
    }

//    删除点赞
    @DeleteMapping("/favorDelete")
    public CommonResult favorDelete(@RequestBody FavorModel favorModel){
        int count=favorService.favorDelete(favorModel);
        return CommonResult.success(count);
    }
}
