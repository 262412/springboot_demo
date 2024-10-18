package com.example.springboot_demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimeAspect {

    /**
     * 环绕通知，用于记录com.example.springboot_demo.service包下所有服务方法的执行时间
     * 该方法在目标方法执行前后执行，用于计算目标方法的执行耗时
     *
     * @param joinPoint 切入点对象，提供了关于目标方法的信息
     * @return 目标方法的执行结果
     * @throws Throwable 如果目标方法抛出异常，该方法也会抛出相同的异常
     */
    @Around("execution(* com.example.springboot_demo.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint)throws Throwable {
        // 记录目标方法开始执行的时间
        long begin = System.currentTimeMillis();

        // 执行目标方法
        Object result = joinPoint.proceed();

        // 记录目标方法执行结束的时间
        long end = System.currentTimeMillis();

        // 计算并记录目标方法的执行耗时
        log.info(joinPoint.getSignature()+"方法执行耗时：{}ms",(end-begin));

        // 返回目标方法的执行结果
        return result;
    }

}
