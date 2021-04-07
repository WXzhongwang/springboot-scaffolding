package com.elastic.example;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shengwangzhong
 */
@SpringBootApplication
@MapperScan("com.elastic.example.dao")
public class ExampleApplication {

    private static final Logger logger = LoggerFactory.getLogger(ExampleApplication.class);

    public static void main(String[] args) {
        logger.info("程序启动");
        SpringApplication.run(ExampleApplication.class, args);
    }

}
