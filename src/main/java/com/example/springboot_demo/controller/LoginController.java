package com.example.springboot_demo.controller;

import com.example.springboot_demo.pojo.Emp;
import com.example.springboot_demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import com.example.springboot_demo.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/Login")
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录:{}",emp);
        Emp e = empService.login(emp);
        return e != null?Result.success(e):Result.error("用户名或密码错误");
    }
}
