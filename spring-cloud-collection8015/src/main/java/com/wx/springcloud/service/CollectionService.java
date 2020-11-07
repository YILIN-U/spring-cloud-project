package com.wx.springcloud.service;


import com.wx.springcloud.model.CollectionModel;

public interface CollectionService {

//    添加收藏信息
    int collectionAdd(CollectionModel collectionModel);

//        删除收藏
    int collectionDelete(CollectionModel collectionModel);
}
