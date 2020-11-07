package com.wx.springcloud.mapper;


import com.wx.springcloud.model.WordModel;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface WordMapper {
    int wordAdd(WordModel wordModel);

    int wordUpdate(WordModel wordModel);

    int wordDelete(String id);

    List<WordModel> getAllWord(WordModel wordModel);

//   更新点赞的数量
    int addFavorCount(WordModel wordModel);

    //    回滚点赞数量
    int backFillFavorCount(WordModel wordModel);

    //找到所要编辑的数据
    WordModel findWordById(String id);
}
