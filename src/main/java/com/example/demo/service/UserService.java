package com.example.demo.service;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.response.ResponseUtil;

/**
 * @author wxl
 */ 
public interface UserService extends IService<User>{



    ResponseUtil<?> deleteUser(int id);

    ResponseUtil<?> updateUser(User user);

    ResponseUtil<?> updateUserStatus(User user);
}
