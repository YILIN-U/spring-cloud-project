package com.wx.springcloud.mapper;


import com.wx.springcloud.model.PermissionModel;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface PermissionMapper {
//    检查权限是否存在
    PermissionModel checkPermission(String permissionCode);

//    权限添加
    int permissionAdd(PermissionModel permissionModel);

//    更新
    int permissionUpdate(PermissionModel permissionModel);

//    删除
    int permissionDelete(String id);

//    得到所有的权限
    List<PermissionModel> getAllPermission(PermissionModel permissionModel);
    //    根据id找到编辑的数据
    PermissionModel findPermissionById(PermissionModel permissionModel);
}
