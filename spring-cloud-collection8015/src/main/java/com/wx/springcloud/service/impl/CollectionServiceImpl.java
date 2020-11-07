package com.wx.springcloud.service.impl;


import com.wx.springcloud.mapper.CollectionMapper;
import com.wx.springcloud.service.CollectionService;
import com.wx.springcloud.model.CollectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionMapper collectionMapper;

//   添加收藏信息
    @Override
    public int collectionAdd(CollectionModel collectionModel) {
        int count=0;
        if (checkWordIsAlreadyCollection(collectionModel)){
            count=collectionMapper.collectionAdd(collectionModel);
        }
        return count;
    }



    //    检查用户是否对该单词已经进行点赞
    private boolean checkWordIsAlreadyCollection(CollectionModel model){
        CollectionModel collectionModel=collectionMapper.checkWordIsAlreadyCollection(model);
        return collectionModel==null;
    }

    //        删除收藏
    @Override
    public int collectionDelete(CollectionModel collectionModel) {
        return collectionMapper.collectionDelete(collectionModel);
    }
}
