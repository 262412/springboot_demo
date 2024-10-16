package com.example.springboot_demo.service;

import com.example.springboot_demo.pojo.PageBean;

/**
 * 员工管理
 */
public interface EmpService {
    PageBean page(Integer page, Integer pageSize);
}
