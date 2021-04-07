package com.qlt.tracing.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.qlt.tracing.tail.mapper", sqlSessionTemplateRef = "tailSqlSessionTemplate")
public class TailDataSourceConfig {

    @Bean
    public SqlSessionFactory tailSqlSessionFactory(@Qualifier("tailDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:templates/test/*.xml"));
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager utailTransactionManager(@Qualifier("tailDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate tailSqlSessionTemplate(@Qualifier("tailSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}