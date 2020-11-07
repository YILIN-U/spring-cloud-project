package com.wx.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleModel {
    private Integer id;
    private String userCode;
    private String roleCode;
    private String roleName;
    private List<String> roleCodes;
}
