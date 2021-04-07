package com.dick.springboot.demo.service;

import com.dick.springboot.demo.model.Role;
import com.dick.springboot.demo.model.User;

public interface LoginService {

    User addUser(User user);

    Role addRole(Role role);

    User findByName(String name);

}