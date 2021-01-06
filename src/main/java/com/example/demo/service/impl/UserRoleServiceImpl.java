package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.UserRole;
import com.example.demo.dao.UserRoleMapper;
import com.example.demo.service.UserRoleService;
/**
 * @author wxl
 */ 
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService{

}
