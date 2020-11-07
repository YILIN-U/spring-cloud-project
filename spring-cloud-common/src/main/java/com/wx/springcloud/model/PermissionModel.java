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
public class PermissionModel implements Serializable {
    private Integer id;
    private String  permissionCode;
    private String permissionName;
    private String permissionValue;
    private Integer status;
    private String createTime;
    private String updateTime;
}
