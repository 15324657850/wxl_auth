package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.response.ResponseUtil;

/**
 * @author wxl
 */
public interface RoleService extends IService<Role> {


    ResponseUtil<IPage<Role>> roleList(Role role);

    ResponseUtil<?> addRole(Role role);

    ResponseUtil<?> updateRole(Role role);

    ResponseUtil<?> deleteRole(Integer id);


}
