package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wxl
 */ 
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}