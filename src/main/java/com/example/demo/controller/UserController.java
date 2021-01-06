package com.example.demo.controller;

import com.example.demo.response.ResponseUtil;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxl
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final  UserService userService;


    public ResponseUtil delete(int id) {
        return userService.deleteUser(id);
    }

}
