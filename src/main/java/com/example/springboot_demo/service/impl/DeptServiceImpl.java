package com.example.springboot_demo.service.impl;

import com.example.springboot_demo.mapper.DeptMapper;
import com.example.springboot_demo.pojo.Dept;
import com.example.springboot_demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list() {
        return null;
    }
}
