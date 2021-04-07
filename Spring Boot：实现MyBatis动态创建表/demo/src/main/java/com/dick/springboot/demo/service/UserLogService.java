package com.dick.springboot.demo.service;

import java.util.List;

import com.dick.springboot.demo.model.UserLog;

public interface UserLogService {

    /**
     * 保存用户日志
     * 
     * @return
     */
    void save(String tableName, UserLog userLog);

    /**
     * 查找全部用户日志
     * 
     * @return
     */
    List<UserLog> findAll(String tableName);

}