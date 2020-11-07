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
public class GroupModel implements Serializable {
    private Integer id;
    private String groupCode;
    private String groupName;
    private String supervision;
    private String supervisionCode;
    private String coach;
    private String coachCode;
    private String createTime;
    private String updateTime;
    private Integer memberCount;
}
