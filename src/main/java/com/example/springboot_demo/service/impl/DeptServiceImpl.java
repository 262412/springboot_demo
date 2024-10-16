package com.example.springboot_demo.service.impl;

import com.example.springboot_demo.mapper.DeptMapper;
import com.example.springboot_demo.pojo.Dept;
import com.example.springboot_demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DeptService的实现类，提供部门相关的业务操作
 */
@Service
public class DeptServiceImpl implements DeptService {

    /**
     * 注入DeptMapper，用于执行与部门表相关的SQL操作
     */
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询并返回所有部门的列表
     *
     * @return 包含所有部门的List集合
     */
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    /**
     * 实现删除操作，通过ID删除对应的部门信息
     *
     * @param id 部门的唯一标识符，用于定位要删除的部门信息
     */
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }

    /**
     * 重写add方法，实现部门信息的添加
     * 该方法通过调用deptMapper的add方法，将部门信息持久化到数据库中
     *
     * @param dept 部门对象，包含要添加的部门的所有信息
     */
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    /**
     * 根据ID获取部门信息
     * 此方法通过调用deptMapper的findById方法实现，根据Integer类型的ID返回相应的Dept对象
     *
     * @param id 部门的唯一标识符
     * @return 返回对应的部门对象，如果找不到则返回null
     */
    @Override
    public Dept get(Integer id) {
        return deptMapper.findById(id);
    }

    /**
     * 更新部门信息
     * 此方法通过调用deptMapper的update方法实现，用于更新Dept对象的信息
     *
     * @param dept 需要更新的部门对象，包含所有需要更新的信息
     */
    @Override
    public void update(Dept dept) {
        deptMapper.update(dept);
    }
}
