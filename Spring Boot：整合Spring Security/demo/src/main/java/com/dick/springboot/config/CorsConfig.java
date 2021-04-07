package com.dick.springboot.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author shengwangzhong
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     *  允许跨域访问的路径
     *  允许跨域访问的源
     *  允许请求方法
     *  预检间隔时间
     *  允许头部设置
     *  是否发送cookie
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
        .maxAge(168000)
        .allowedHeaders("*")
        .allowCredentials(true);
    }
}