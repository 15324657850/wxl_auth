package com.example.demo.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.PermissionMapper;
import com.example.demo.dao.RolePermissionMapper;
import com.example.demo.entity.Permission;
import com.example.demo.entity.RolePermission;
import com.example.demo.response.ResponseUtil;
import com.example.demo.service.PermissionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wxl
 */
@Service
@Slf4j
@AllArgsConstructor
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    private final RolePermissionMapper rolePermissionMapper;

    @Override
    public ResponseUtil<?> updatePermission(Permission permission) {
        if (StringUtils.isNotEmpty(permission.getPermission())) {
            if (count(Wrappers.<Permission>lambdaQuery().eq(Permission::getPermission, permission.getPermission())) > 1) {
                ResponseUtil.byError("权限编码已经存在");
            }
        }

        if (count(Wrappers.<Permission>lambdaQuery().eq(Permission::getName, permission.getName())) > 1) {
            ResponseUtil.byError("权限名字已经存在");
        }
        permission.setUpdateTime(new Date());

        if (updateById(permission)) {
            return ResponseUtil.bySuccess();
        }
        return ResponseUtil.byError("修改权限失败");
    }

    @Override
    public ResponseUtil<?> addPermission(Permission permission) {
        if (StringUtils.isNotEmpty(permission.getPermission())) {
            if (count(Wrappers.<Permission>lambdaQuery().eq(Permission::getPermission, permission.getPermission())) > 1) {
                ResponseUtil.byError("权限编码已经存在");
            }
        }

        if (count(Wrappers.<Permission>lambdaQuery().eq(Permission::getName, permission.getName())) > 1) {
            ResponseUtil.byError("权限名字已经存在");
        }
        permission.setCreateTime(new Date());

        if (save(permission)) {
            return ResponseUtil.bySuccess();
        }
        return ResponseUtil.byError("添加权限失败");
    }

    @Override
    public ResponseUtil<?> deletePermission(Integer id) {
        Permission permission = getById(id);
        if (!"1".equals(permission.getType())) {
            List<Permission> list = getChildren(id);
            removeByIds(list.stream().map(Permission::getId).collect(Collectors.toList()));
        }
        if (removeById(id)) {
            rolePermissionMapper.delete(Wrappers.<RolePermission>lambdaQuery().eq(RolePermission::getPermissionId, id));
            return ResponseUtil.bySuccess();
        }

        return ResponseUtil.byError("删除权限失败");
    }

    private List<Permission> getChildren(Integer id) {
        List<Permission> list = list(Wrappers.<Permission>lambdaQuery()
                .select(Permission::getId)
                .eq(Permission::getParentId, id)
        );
        if (CollectionUtil.isEmpty(list)) {
            return Collections.emptyList();
        }

        ArrayList<Permission> permissions = new ArrayList<>(list);
        list.forEach(str -> permissions.addAll(getChildren(str.getId())));
        return permissions;
    }
}
