package com.wx.springcloud.service;


import com.wx.springcloud.model.WordModel;

import java.util.List;

public interface WordService {
//    添加word
    int wordAdd(WordModel wordModel);

//    更新单词
    int wordUpdate(WordModel wordModel);

//    单词删除
    int wordDelete(String id);

//    得到所有单词
    List<WordModel> getAllWord(WordModel wordModel);

    //更新点赞的数量
    int addFavorCount(WordModel wordModel);

    //    回滚点赞数量
    int backFillFavorCount(WordModel wordModel);

 //找到所要编辑的数据
    WordModel findWordById(String id);
}
