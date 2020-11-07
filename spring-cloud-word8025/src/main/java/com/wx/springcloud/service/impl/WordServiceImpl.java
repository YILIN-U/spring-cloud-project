package com.wx.springcloud.service.impl;


import com.wx.springcloud.mapper.WordMapper;
import com.wx.springcloud.model.WordModel;
import com.wx.springcloud.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    WordMapper wordMapper;

//    添加单词
    @Override
    public int wordAdd(WordModel wordModel) {

        return wordMapper.wordAdd(wordModel);
    }

    @Override
    public int wordUpdate(WordModel wordModel) {
        return wordMapper.wordUpdate(wordModel);
    }

    @Override
    public int wordDelete(String id) {
        return wordMapper.wordDelete(id);
    }

    @Override
    public List<WordModel> getAllWord(WordModel wordModel) {
        return wordMapper.getAllWord(wordModel);
    }

    //更新点赞的数量
    @Override
    public int addFavorCount(WordModel wordModel) {
        return wordMapper.addFavorCount(wordModel);
    }

    //    回滚点赞数量
    @Override
    public int backFillFavorCount(WordModel wordModel) {
        return wordMapper.backFillFavorCount(wordModel);
    }

    //找到所要编辑的数据
    @Override
    public WordModel findWordById(String id) {
        return wordMapper.findWordById(id);
    }
}
