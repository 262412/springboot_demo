package com.example.springboot_demo.controller;

import com.example.springboot_demo.pojo.Emp;
import com.example.springboot_demo.service.EmpService;
import com.example.springboot_demo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import com.example.springboot_demo.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/login")
@RestController
public class LoginController {
    // 注入EmpService接口，用于调用其业务方法
    @Autowired
    private EmpService empService;

    // 处理员工登录请求
    // 该方法接收一个表示员工的JSON对象，尝试验证员工的用户名和密码
    @PostMapping
    public Result login(@RequestBody Emp emp) {
        // 记录员工登录尝试的信息
        log.info("员工登录:{}", emp);
        // 调用empService的login方法进行登录验证
        Emp e = empService.login(emp);
        if (e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        // 根据验证结果返回相应的Response对象
        // 如果验证成功（e不为null），返回包含员工信息的成功响应
        // 如果验证失败（e为null），返回错误消息的响应
        return Result.error("用户名或密码错误");
    }
}
