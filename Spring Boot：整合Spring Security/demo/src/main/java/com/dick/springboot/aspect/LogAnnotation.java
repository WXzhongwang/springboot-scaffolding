package com.dick.springboot.aspect;

import java.lang.annotation.*;

/**
 * @author shengwangzhong
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAnnotation {
    /**
     * 方法描述,可使用占位符获取参数:{{tel}}
     */
    String detail() default "";

    /**
     * 日志等级:自己定，此处分为1-9
     */
    int level() default 0;

    /**
     * 操作类型(enum):主要是select,insert,update,delete
     */
    OperationType operationType() default OperationType.UNKNOWN;

    /**
     * 被操作的对象(此处使用enum):可以是任何对象，如表名(user)，或者是工具(redis)
     */
    OperationUnit operationUnit() default OperationUnit.UNKNOWN;
}