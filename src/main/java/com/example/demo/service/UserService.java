package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.User;
import com.example.demo.response.ResponseUtil;

/**
 * @author wxl
 */
public interface UserService extends IService<User> {
    ResponseUtil<IPage<User>> userList(User user);

    ResponseUtil<?> deleteUser(int id);

    ResponseUtil<?> updateUser(User user);

    ResponseUtil<?> addUser(User user);

    ResponseUtil<?> updateUserStatus(User user);

    ResponseUtil<?> updateUserPassword(User user);


}
