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
public class RoleModel implements Serializable {

    private Integer id;
    private String roleCode;
    private String roleName;
    private String createTime;
    private String updateTime;
    private String status;
    private Integer roleDelete;

}
