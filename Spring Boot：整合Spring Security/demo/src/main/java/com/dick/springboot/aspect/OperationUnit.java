package com.dick.springboot.aspect;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description 被操作的单元
 * @date created on 2019/11/25
 */
public enum OperationUnit {

    UNKNOWN("unknown"),
    USER("user"),
    EMPLOYEE("employee"),
    Redis("redis");

    private String value;

    OperationUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
