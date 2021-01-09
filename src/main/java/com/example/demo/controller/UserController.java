package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.entity.User;
import com.example.demo.response.ResponseUtil;
import com.example.demo.service.UserService;
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
@RequestMapping(value = "/user")
@Api(tags = "用户接口")
public class UserController {

    private final UserService userService;

    @DeleteMapping
    @ApiOperation("删除用户")
    public ResponseUtil<?> delete(@RequestParam int id) {
        return userService.deleteUser(id);
    }

    @GetMapping
    @ApiOperation(value = "分页查询用户列表")
    public ResponseUtil<IPage<User>> userList(@ModelAttribute User user) {
        return userService.userList(user);
    }

    @PutMapping
    @ApiOperation("修改用户信息")
    public ResponseUtil<?> update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping
    @ApiOperation("添加用户信息")
    public ResponseUtil<?> insert(@RequestBody User user) {
        return userService.addUser(user);
    }
}
