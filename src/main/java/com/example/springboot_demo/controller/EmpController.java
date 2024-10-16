package com.example.springboot_demo.controller;

import com.example.springboot_demo.pojo.PageBean;
import com.example.springboot_demo.pojo.Result;
import com.example.springboot_demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    // 注入EmpService接口的实现类，用于调用员工管理相关业务逻辑
    @Autowired
    private EmpService empService;

    // 处理HTTP GET请求，路径为"/emps"，用于分页查询员工信息
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "YYYY-MM-DD") LocalDate begin,
                       @DateTimeFormat(pattern = "YYYY-MM-DD") LocalDate end){
        // 记录分页查询的日志，包括当前页码和每页大小
        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        // 调用EmpService的分页查询方法，返回PageBean对象，包含分页后的员工数据及总记录数等信息
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        // 返回查询结果，封装为Result对象，表示操作成功，并携带分页数据
        return Result.success(pageBean);
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        // 将逗号分隔的ID字符串转换为数组，方便后续处理
        log.debug("批量删除操作，ids：{}", ids);
        // 调用EmpService的批量删除方法，传入要删除的员工ID数组
        empService.delete(ids);
        // 返回删除结果，表示操作成功
        return Result.success();
    }

}
