package com.dick.springboot.demo.service.impl;
import java.util.List;

import com.dick.springboot.demo.dao.UserLogMapper;
import com.dick.springboot.demo.model.UserLogConfig;
import com.dick.springboot.demo.service.UserLogConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dick.springboot.demo.dao.UserLogConfigMapper;

@Service
public class UserLogConfigServiceImpl implements UserLogConfigService {
    
    @Autowired
    private UserLogConfigMapper userLogConfigMapper;
    @Autowired
    private UserLogMapper userLogMapper;
    
    @Override
    public void save(UserLogConfig userLogConfig) {
    	// 插入
    	userLogConfigMapper.insertSelective(userLogConfig);
    	// 添加配置时，创建日志存储表
    	String tableName = userLogConfig.getTableName();
    	if(userLogMapper.existTable(tableName) > 0) {
    		userLogMapper.dropTable(tableName);
    	}
    	userLogMapper.createTable(tableName);
    }
    
    @Override
    public List<UserLogConfig> findAll() {
        return userLogConfigMapper.selectAll();
    }
}