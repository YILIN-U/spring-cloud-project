package com.wx.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WordModel implements Serializable {
    private Integer id;
    private String wordCode;
    private String chinese;
    private String english;
    private String userCode;
    private String userName;
    private Integer favorCount;
    private String submitTime;
    private String updateTime;

}
