package com.qlt.tracing.self.service.impl;

import com.qlt.tracing.self.mapper.TestMapper;
import com.qlt.tracing.self.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2021/1/7
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    @Transactional(value = "selfTransactionManager")
    public void updatAge() {
        testMapper.updateAge();
        throw new RuntimeException("抛出异常验证回滚");
    }
}
