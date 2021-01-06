package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UserRoleMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.response.ResponseUtil;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wxl
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final  UserRoleMapper userRoleMapper;

    @Override
    public ResponseUtil<?> deleteUser(int id) {
        User user = super.getById(id);
        if (user == null) {
            return ResponseUtil.bySuccess();
        }
        if (removeById(id)) {
            userRoleMapper.delete(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, id));
            return ResponseUtil.bySuccess("删除用户成功");
        }

        return ResponseUtil.bySuccess("删除用户失败");
    }
}
