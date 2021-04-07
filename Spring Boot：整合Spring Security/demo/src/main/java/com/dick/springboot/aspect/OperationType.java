package com.dick.springboot.aspect;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description 操作类型
 * @date created on 2019/11/25
 */
public enum OperationType {

    UNKNOWN("unknown"),
    DELETE("delete"),
    SELECT("select"),
    UPDATE("update"),
    INSERT("insert");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    OperationType(String s) {
        this.value = s;
    }
}