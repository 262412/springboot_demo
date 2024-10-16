package com.example.springboot_demo.service;

import com.example.springboot_demo.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/*
 * 员工管理
 */

/**
 * 定义员工服务接口，用于处理员工相关的业务操作
 */
public interface EmpService {

    /**
     * 实现员工信息的分页查询
     * 本方法允许用户根据指定的页码和每页记录数获取员工信息
     * 分页查询有助于提高查询效率和响应速度，特别是在处理大量数据时
     *
     * @param page 当前页码，从1开始计数
     * @param pageSize 每页包含的记录数
     * @param name 员工姓名，可选参数用于根据姓名筛选员工
     * @param gender 员工性别，可选参数用于根据性别筛选员工
     * @param begin 查询起始日期，可选参数用于根据入职时间筛选员工
     * @param end 查询结束日期，可选参数用于根据入职时间筛选员工
     * @return 返回一个PageBean对象，包含当前页码的员工记录和页码信息
     *         PageBean对象封装了分页查询的结果，包括当前页的员工数据、总记录数、总页数等信息
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);
}

