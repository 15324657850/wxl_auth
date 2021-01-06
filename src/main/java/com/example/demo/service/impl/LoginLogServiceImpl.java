package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.LoginLogMapper;
import com.example.demo.entity.LoginLog;
import com.example.demo.service.LoginLogService;
import org.springframework.stereotype.Service;
/**
 * @author wxl
 */ 
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService{

}
