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

    /**
     * 根据部门ID获取部门信息
     *
     * @param id 部门ID，用于唯一标识一个部门
     * @return 返回对应的部门对象，如果找不到则返回null
     */
    Dept get(Integer id);

    /**
     * 更新部门信息
     * 此方法用于修改现有部门的信息，覆盖旧的数据
     *
     * @param dept 包含更新后部门信息的对象
     */
    void update(Dept dept);
}

