package com.wx.springcloud.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupUserModel {
    private Integer id;
    private String groupCode;
    private String userCode;
}
