package com.example.springboot_demo.service.impl;

import com.example.springboot_demo.mapper.EmpMapper;
import com.example.springboot_demo.pojo.Emp;
import com.example.springboot_demo.pojo.PageBean;
import com.example.springboot_demo.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    // 自动注入EmpMapper对象，用于访问数据库
    @Autowired
    private EmpMapper empMapper;


//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        Long count = empMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
//        PageBean pageBean = new PageBean(count, empList);
//        return pageBean;
//    }
    @Override
    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.list();
        Page<Emp> p = (Page<Emp>) empList;
        return new PageBean(p.getTotal(), p.getResult());
    }

}
