package com.example.demo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.RoleMapper;
import com.example.demo.dao.RolePermissionMapper;
import com.example.demo.entity.Role;
import com.example.demo.entity.RolePermission;
import com.example.demo.response.ResponseUtil;
import com.example.demo.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wxl
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    private final RolePermissionMapper rolePermissionMapper;

    @Override
    public ResponseUtil<IPage<Role>> roleList(Role role) {
        LambdaQueryWrapper<Role> lambdaQuery = Wrappers.<Role>lambdaQuery();

        if (StringUtils.isNotEmpty(role.getName())) {
            lambdaQuery.like(Role::getName, role.getName());
        }
        lambdaQuery.orderByDesc(Role::getId);

        Page<Role> page = page(new Page<>(1, 10), lambdaQuery);
        return ResponseUtil.bySuccessData(page);
    }

    @Override
    public ResponseUtil<?> addRole(Role role) {
        if (count(Wrappers.<Role>lambdaQuery().eq(Role::getName, role.getName())) > 1) {
            return ResponseUtil.byError("该角色名字已被使用");
        }

        role.setCreateTime(new Date());
        if (save(role)) {
            return ResponseUtil.bySuccess();
        }
        return ResponseUtil.byError("添加失败");
    }

    @Override
    public ResponseUtil<?> updateRole(Role role) {
        if (StringUtils.isNotEmpty(role.getName())) {
            if (count(Wrappers.<Role>lambdaQuery().eq(Role::getName, role.getName())) > 1) {
                return ResponseUtil.byError("该角色名字已被使用");
            }
        }

        role.setUpdateTime(new Date());
        if (updateById(role)) {
            return ResponseUtil.bySuccess();
        }
        return ResponseUtil.byError("添加失败");
    }

    @Override
    public ResponseUtil<?> deleteRole(Integer id) {
        Role role = getById(id);
        if (ObjectUtil.isNull(role)) {
            return ResponseUtil.byError("该角色不存在");
        }
        if (removeById(id)) {
            rolePermissionMapper.delete(Wrappers.<RolePermission>lambdaQuery()
                    .eq(RolePermission::getId, id)
            );
            return ResponseUtil.bySuccess();
        }

        return ResponseUtil.byError("删除角色失败");
    }
}

