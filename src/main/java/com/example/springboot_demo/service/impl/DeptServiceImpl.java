package com.example.springboot_demo.service.impl;

import com.example.springboot_demo.mapper.DeptMapper;
import com.example.springboot_demo.pojo.Dept;
import com.example.springboot_demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
