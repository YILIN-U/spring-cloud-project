package com.wx.springcloud.controller;



import com.wx.springcloud.service.CollectionService;
import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.CollectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    CollectionService collectionService;

//    添加收藏信息
    @PostMapping("/collectionAdd")
    public CommonResult collectionAdd(@RequestBody CollectionModel collectionModel){
        int count=collectionService.collectionAdd(collectionModel);
        return CommonResult.success(count);

    }

//    删除收藏
    @DeleteMapping("/collectionDelete")
    public CommonResult collectionDelete(@RequestBody CollectionModel collectionModel){
        int count=collectionService.collectionDelete(collectionModel);
        return CommonResult.success(count);
    }



}
