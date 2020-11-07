package com.wx.springcloud.mapper;


import com.wx.springcloud.model.FavorModel;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface FavorMapping {
    //    新增收藏信息
    int favorAdd(FavorModel favorModel);

//    检查用户是否对该单词已经进行点赞
    FavorModel checkWordIsAlreadyFavor(FavorModel model);//

    //    删除点赞
    int favorDelete(FavorModel favorModel);
}
