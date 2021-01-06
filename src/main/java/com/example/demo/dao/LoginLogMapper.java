package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;import java.util.List;

/**
 * @author wxl
 */
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {
    long countByExample(LoginLogExample example);

    int deleteByExample(LoginLogExample example);

    List<LoginLog> selectByExample(LoginLogExample example);

    int updateByExampleSelective(@Param("record") LoginLog record, @Param("example") LoginLogExample example);

    int updateByExample(@Param("record") LoginLog record, @Param("example") LoginLogExample example);
}