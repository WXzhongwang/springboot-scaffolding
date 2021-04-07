package com.dick.springboot.demo.service.impl;
import java.util.List;

import com.dick.springboot.demo.dao.SysUserMapper;
import com.dick.springboot.demo.model.SysUser;
import com.dick.springboot.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Override
    public SysUser findByUserId(Long userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.selectAll();
    }
}