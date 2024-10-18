package com.example.springboot_demo.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
/**
 * Log注解用于标记在方法执行前后需要记录日志的位置
 * 它提供了一种声明式的方式来控制日志记录的行为，而无需在业务代码中显式地编写日志记录逻辑
 * 主要用途包括记录方法的调用信息、参数、返回值以及执行时间等，以便于监控和审计
 */
public @interface Log {
}
