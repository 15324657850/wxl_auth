package com.example.demo.service;

import com.example.demo.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.response.ResponseUtil;

/**
 * @author wxl
 */
public interface PermissionService extends IService<Permission> {

    ResponseUtil<?> deletePermission(Integer id);

    ResponseUtil<?> updatePermission(Permission permission);

    ResponseUtil<?> addPermission(Permission permission);


}
