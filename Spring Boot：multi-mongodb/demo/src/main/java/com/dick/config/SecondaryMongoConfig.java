package com.dick.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.dick.config.props.MultipleMongoProperties;

@Configuration
@EnableConfigurationProperties(MultipleMongoProperties.class)
@EnableMongoRepositories(basePackages = "com.neo.repository.secondary", mongoTemplateRef = "secondaryMongoTemplate")
public class SecondaryMongoConfig {

}
