package com.wx.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionModel implements Serializable {
    private Integer id;
    private String roleCode;
    private String permissionCode;
    private String permissionName;
    private List<String> permissionCodes;
}
