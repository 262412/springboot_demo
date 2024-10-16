package com.example.springboot_demo.service;

import com.example.springboot_demo.pojo.Dept;

import java.util.List;

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

    /**
     * 删除指定ID的对象
     *
     * @param id 要删除的对象的ID
     */
    void delete(Integer id);

    /**
     * 添加部门信息
     *
     * @param dept 部门对象，包含要添加的部门信息
     *            包括部门ID、部门名称、部门描述等属性
     */
    void add(Dept dept);

    Dept get(Integer id);

    void update(Dept dept);
}

