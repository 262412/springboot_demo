package com.example.springboot_demo.aop;

import com.alibaba.fastjson2.JSONObject;
import com.example.springboot_demo.mapper.OperateLogMapper;
import com.example.springboot_demo.pojo.OperateLog;
import com.example.springboot_demo.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogAspect {

    // 自动注入HttpServletRequest对象，用于获取请求头信息
    @Autowired
    private HttpServletRequest request;

    // 自动注入OperateLogMapper对象，用于操作日志的持久化
    @Autowired
    private OperateLogMapper operateLogMapper;

    /**
     * AOP切面方法，用于记录操作日志
     * 该方法会在标注了@Log注解的方法执行前后被调用
     *
     * @param joinPoint 切入点对象，提供了关于切点的详细信息
     * @return 执行的目标方法的返回值
     * @throws Throwable 目标方法执行过程中可能抛出的异常
     */
    @Around("@annotation(com.example.springboot_demo.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 从请求头中获取JWT令牌
        String jwt = request.getHeader("token");
        // 解析JWT令牌，获取载荷信息
        Claims claims = JwtUtils.parseJWT(jwt);
        // 从载荷中获取操作用户ID
        Integer operateUser = (Integer) claims.get("id");
        // 获取当前操作时间
        LocalDateTime operateTime = LocalDateTime.now();
        // 获取目标类的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取目标方法的参数
        Object[] args = joinPoint.getArgs();
        // 将方法参数转换为字符串表示
        String methodParams = Arrays.toString(args);
        // 记录方法开始执行的时间
        Long begin = System.currentTimeMillis();
        // 执行目标方法
        Object result = joinPoint.proceed();
        // 记录方法执行结束的时间
        Long end = System.currentTimeMillis();
        // 将方法的返回值转换为JSON字符串
        String returnValue = JSONObject.toJSONString(result);
        // 计算方法执行耗时
        Long costTime = end - begin;
        // 创建操作日志对象，并设置相关属性
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);
        // 将操作日志持久化到数据库
        operateLogMapper.insert(operateLog);
        // 打印日志，记录操作日志记录成功的消息
        log.info("AOP操作日志记录成功：{}", operateLog);
        // 返回目标方法的执行结果
        return result;
    }
}
