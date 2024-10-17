package com.example.springboot_demo.controller;

import com.example.springboot_demo.pojo.Emp;
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
    private EmpService  empService;

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

    // 处理HTTP DELETE请求，路径为"/emps/{ids}"，用于批量删除员工
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        // 将逗号分隔的ID字符串转换为数组，方便后续处理
        log.debug("批量删除操作，ids：{}", ids);
        // 调用EmpService的批量删除方法，传入要删除的员工ID数组
        empService.delete(ids);
        // 返回删除结果，表示操作成功
        return Result.success();
    }

    // 处理HTTP POST请求，路径为"/emps"，用于添加员工
    @PostMapping
    public Result add(@RequestBody Emp emp){
        // 记录添加员工信息的日志，包括员工信息
        log.info("添加员工，员工信息：{}", emp);
        // 调用EmpService的添加员工方法，传入员工信息，执行添加操作
        empService.add(emp);
        // 返回添加结果，表示操作成功
        return Result.success();
    }
    /**
     * 根据ID查询员工信息的HTTP GET请求处理方法
     *
     * @param id 员工ID，从URL路径中获取
     * @return 返回查询到的员工信息，封装在Result对象中
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        // 记录根据ID查询员工信息的日志，包括员工ID
        log.info("根据ID查询员工信息，id：{}", id);
        // 调用EmpService的根据ID查询员工信息方法，传入员工ID，返回员工信息
        Emp emp = empService.getById(id);
        // 返回查询结果，封装为Result对象，表示操作成功，并携带员工信息
        return Result.success(emp);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp){
        // 记录更新员工信息的日志，包括员工信息
        log.info("更新员工信息，员工信息：{}", emp);
        // 调用EmpService的更新员工信息方法，传入员工信息，执行更新操作
        empService.update(emp);
        // 返回更新结果，表示操作成功
        return Result.success();
    }
}
