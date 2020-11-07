package com.wx.springcloud.controller;


import com.wx.springcloud.common.CommonResult;
import com.wx.springcloud.model.WordModel;
import com.wx.springcloud.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    WordService wordService;

    @PostMapping("/wordAdd")
    public CommonResult wordAdd(@RequestBody WordModel wordModel){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        wordModel.setSubmitTime(simpleDateFormat.format(new Date()));
        int count=wordService.wordAdd(wordModel);
        return CommonResult.success(count);
    }

    @PutMapping("/wordUpdate")
    public CommonResult wordUpdate(@RequestBody WordModel wordModel){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        wordModel.setUpdateTime(simpleDateFormat.format(new Date()));
        int count=wordService.wordUpdate(wordModel);
        return CommonResult.success(count);
    }

    @DeleteMapping("/wordDelete/{id}")
    public CommonResult wordDelete(@PathVariable(value = "id") String id){
        int count=wordService.wordDelete(id);
        return CommonResult.success(count);
    }

    @PostMapping("/getAllWord")
    public CommonResult getAllWord(@RequestBody(required = false) WordModel wordModel){
        List<WordModel> list=wordService.getAllWord(wordModel);
        return CommonResult.success(list);
    }

//更新点赞的数量
    @PutMapping("/addFavorCount")
    public CommonResult addFavorCount(@RequestBody WordModel wordModel){
        int count=wordService.addFavorCount(wordModel);
        return CommonResult.success(count);
    }

//    回滚点赞数量
    @PutMapping("/backFillFavorCount")
    public CommonResult backFillFavorCount(@RequestBody WordModel wordModel){
        int count=wordService.backFillFavorCount(wordModel);
        return CommonResult.success(count);
    }

//找到所要编辑的数据
    @GetMapping("/findWordById/{id}")
    public CommonResult findWordById(@PathVariable String id){
        WordModel wordModel=wordService.findWordById(id);

        return CommonResult.success(wordModel);

    }



}
