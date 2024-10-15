package com.example.springboot_demo.service;

import com.example.springboot_demo.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
/**
 * DeptService接口，定义了部门服务的操作
 * 该接口提供了一个方法来获取部门列表
 */
public interface DeptService {
    /**
     * 获取所有部门的列表
     *
     * @return 包含所有部门信息的List集合
     */
    List<Dept> list();
}

