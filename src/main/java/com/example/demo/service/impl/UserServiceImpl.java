package com.example.demo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UserRoleMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.response.ResponseUtil;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wxl
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserRoleMapper userRoleMapper;

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

    @Override
    public ResponseUtil<?> updateUser(User user) {
        if (StringUtils.isNotEmpty(user.getUsername())) {
            if (count(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername())) > 1) {
                return ResponseUtil.byError("该用户名已被使用");
            }
        }
        if (StringUtils.isNotEmpty(user.getPhone())) {
            if (count(Wrappers.<User>lambdaQuery().eq(User::getPhone, user.getPhone())) > 1) {
                return ResponseUtil.byError("该手机号已被使用");
            }
        }
        user.setUpdateTime(new Date());
        if (updateById(user)) {
            return ResponseUtil.bySuccess();
        }
        return ResponseUtil.byError("修改用户失败");
    }

    @Override
    public ResponseUtil<?> addUser(User user) {

        if (count(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername())) > 1) {
            return ResponseUtil.byError("该用户名已被使用");
        }

        if (count(Wrappers.<User>lambdaQuery().eq(User::getPhone, user.getPhone())) > 1) {
            return ResponseUtil.byError("该手机号已被使用");
        }
        // 8个字符的随机字符串，作为加密的随机盐
        String salt = RandomUtil.randomString(8);
        log.info("用户 {}  盐值为 {}", user.getUsername(), salt);
        Md5Hash md5pwd = new Md5Hash(user.getPassword(), salt, 2048);
        user.setCreateTime(new Date());
        user.setPassword(md5pwd.toHex());
        user.setSalt(salt);

        if (save(user)) {
            return ResponseUtil.bySuccess();
        }

        return ResponseUtil.byError("添加用户失败");
    }

    @Override
    public ResponseUtil<?> updateUserStatus(User user) {
        user.setUpdateTime(new Date());
        if (updateById(user)) {
            return ResponseUtil.bySuccess("更新用户状态成功");
        }
        return ResponseUtil.byError("更新用户状态失败");

    }

    @Override
    public ResponseUtil<?> updateUserPassword(User user) {

        User user1 = getById(user.getId());
        if (ObjectUtil.isNull(user1)) {
            return ResponseUtil.byError("用户不存在");
        }

        Md5Hash md5Hash = new Md5Hash(user.getPassword(), user1.getSalt(), 2048);
        user.setPassword(md5Hash.toHex());
        user.setUpdateTime(new Date());

        if (updateById(user)) {
            return ResponseUtil.bySuccess();
        }

        return ResponseUtil.byError("修改密码失败");
    }

    @Override
    public ResponseUtil<IPage<User>> userList(User user) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();

        if (StringUtils.isNotEmpty(user.getUsername())) {
            wrapper.like(User::getUsername, user.getUsername());
        }

        if (user.getStatus() != null) {
            wrapper.eq(User::getStatus, user.getStatus());
        }

        if (StringUtils.isNotEmpty(user.getPhone())) {
            wrapper.likeRight(User::getPhone, user.getPhone());
        }

        wrapper.ne(User::getId, user.getId())
                .orderByDesc(User::getId);

        Page<User> page = page(new Page<>(1, 10), wrapper);
        return ResponseUtil.bySuccessData(page);
    }
}
