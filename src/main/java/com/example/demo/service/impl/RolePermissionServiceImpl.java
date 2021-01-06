package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.RolePermission;
import com.example.demo.dao.RolePermissionMapper;
import com.example.demo.service.RolePermissionService;
/**
 * @author wxl
 */ 
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService{

}
