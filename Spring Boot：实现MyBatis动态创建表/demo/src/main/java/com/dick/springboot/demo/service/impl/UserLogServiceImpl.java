package com.dick.springboot.demo.service.impl;
import java.util.List;

import com.dick.springboot.demo.dao.UserLogMapper;
import com.dick.springboot.demo.model.UserLog;
import com.dick.springboot.demo.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLogServiceImpl implements UserLogService {
    
    @Autowired
    private UserLogMapper userLogMapper;
    
    @Override
    public void save(String tableName, UserLog userLog) {
    	// 插入
    	userLogMapper.insertSelective(tableName, userLog);
    }
    
    @Override
    public List<UserLog> findAll(String tableName) {
        return userLogMapper.selectAll(tableName);
    }
}