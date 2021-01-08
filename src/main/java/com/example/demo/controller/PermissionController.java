package com.example.demo.controller;

import com.example.demo.entity.Permission;
import com.example.demo.response.ResponseUtil;
import com.example.demo.service.PermissionService;
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
@RequestMapping(value = "/permission")
@Api(tags = "权限接口")
public class PermissionController {


    private final PermissionService permissionService;

    @DeleteMapping
    @ApiOperation("删除权限")
    public ResponseUtil delete(@RequestParam int id) {
        return permissionService.deletePermission(id);
    }


    @PutMapping
    @ApiOperation("修改权限信息")
    public ResponseUtil<?> update(@RequestBody Permission permission) {
        return permissionService.updatePermission(permission);
    }

    @PostMapping
    @ApiOperation("添加权限信息")
    public ResponseUtil<?> insert(@RequestBody Permission permission) {
        return permissionService.addPermission(permission);
    }
}
