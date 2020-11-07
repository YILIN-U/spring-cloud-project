package com.wx.springcloud.service.impl;

import com.wx.springcloud.mapper.FavorMapping;
import com.wx.springcloud.model.FavorModel;
import com.wx.springcloud.service.FavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FavorServiceImpl implements FavorService {

    @Autowired
    FavorMapping favorMapping;

    //    新增收藏信息
    @Override
    public int favorAdd(FavorModel favorModel) {
        int count=0;
        if (checkWordIsAlreadyFavor(favorModel)){
             count=favorMapping.favorAdd(favorModel);
        }
        return count;
    }

    //    检查用户是否对该单词已经进行点赞
    private boolean checkWordIsAlreadyFavor(FavorModel model){
        FavorModel favorModel=favorMapping.checkWordIsAlreadyFavor(model);
        return favorModel==null;
    }

//    删除点赞
    @Override
    public int favorDelete(FavorModel favorModel) {
        return favorMapping.favorDelete(favorModel);
    }

}
