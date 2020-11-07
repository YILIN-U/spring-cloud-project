package com.wx.springcloud.mapper;


import com.wx.springcloud.model.CollectionModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollectionMapper {
    //   添加收藏信息
    int collectionAdd(CollectionModel collectionModel);

    //    检查用户是否对该单词已经进行点赞
    CollectionModel checkWordIsAlreadyCollection(CollectionModel model);


    //        删除收藏
    int collectionDelete(CollectionModel collectionModel);
}
