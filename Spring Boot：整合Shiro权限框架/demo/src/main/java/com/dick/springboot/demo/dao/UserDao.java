package com.dick.springboot.demo.dao;

import com.dick.springboot.demo.model.User;

public interface UserDao extends BaseDao<User, Long> {

    User findByName(String name);

}