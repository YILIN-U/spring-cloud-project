package com.wx.springcloud.service;


import com.wx.springcloud.model.FavorModel;

public interface FavorService {
//    新增收藏信息
    int favorAdd(FavorModel favorModel);

    //    删除点赞
    int favorDelete(FavorModel favorModel);
}
