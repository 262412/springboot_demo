package com.example.springboot_demo.exception;

import com.example.springboot_demo.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
/*
 * 全局异常处理器类，用于统一处理系统中抛出的异常
 */
public class GlobalExceptionHandler {
    /**
     * 处理系统中抛出的异常
     *
     * @param ex 异常对象，包含异常的具体信息
     * @return 返回一个Result对象，包含错误信息，用于向用户展示
     */
    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex){
        // 打印异常堆栈信息，便于调试和记录日志
        ex.printStackTrace();
        // 返回错误结果，提示操作失败，并建议联系管理员
        return Result.error("对不起，操作失败，请联系管理员");
    }
}

