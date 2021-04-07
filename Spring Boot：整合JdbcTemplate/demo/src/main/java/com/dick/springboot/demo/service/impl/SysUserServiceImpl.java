package com.dick.springboot.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dick.springboot.demo.dao.SysUserDao;
import com.dick.springboot.demo.model.SysUser;
import com.dick.springboot.demo.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public void save(SysUser user) {
        sysUserDao.save(user);
    }

    @Override
    public void delete(String id) {
        sysUserDao.delete(id);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }

}