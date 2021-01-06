package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Log;
import com.example.demo.dao.LogMapper;
import com.example.demo.service.LogService;
/**
 * @author wxl
 */ 
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService{

}
