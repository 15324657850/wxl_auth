package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.entity.Role;
import com.example.demo.response.ResponseUtil;
import com.example.demo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author wxl
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/role")
@Api(tags = "角色接口")
public class RoleController {


    private final RoleService roleService;

    @DeleteMapping
    @ApiOperation("删除角色")
    public ResponseUtil delete(@RequestParam int id) {
        return roleService.deleteRole(id);
    }

    @GetMapping
    @ApiOperation(value = "分页查询角色列表")
    public ResponseUtil<IPage<Role>> userList(@ModelAttribute Role role) {
        return roleService.roleList(role);
    }

    @PutMapping
    @ApiOperation("修改角色信息")
    public ResponseUtil<?> update(@RequestBody Role role) {
        return roleService.updateRole(role);
    }

    @PostMapping
    @ApiOperation("添加角色信息")
    public ResponseUtil<?> insert(@RequestBody Role role) {
        return roleService.addRole(role);
    }

}
