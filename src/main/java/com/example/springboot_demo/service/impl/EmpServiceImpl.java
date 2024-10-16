package com.example.springboot_demo.service.impl;

import com.example.springboot_demo.mapper.EmpMapper;
import com.example.springboot_demo.pojo.Emp;
import com.example.springboot_demo.pojo.PageBean;
import com.example.springboot_demo.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    /**
     * 分页查询员工信息
     *
     * @param page     当前页码
     * @param pageSize 每页显示条数
     * @return 返回封装了员工信息的PageBean对象
     *
     * 说明：本方法通过MyBatis的PageHelper插件实现分页查询功能
     *       首先，通过PageHelper.startPage方法设置分页参数，然后调用empMapper的list方法获取分页后的员工列表
     *       最后，将获取的分页数据转换为PageBean对象返回，其中包含了总记录数和当前页的员工数据
     */
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize); // 启动分页，并设置当前页码和每页显示条数
        List<Emp> empList = empMapper.list(name, gender, begin, end); // 调用empMapper的list方法获取分页后的员工列表
        Page<Emp> p = (Page<Emp>) empList; // 将员工列表转换为Page<Emp>类型，以便获取总记录数和分页数据
        return new PageBean(p.getTotal(), p.getResult()); // 将总记录数和分页数据封装为PageBean对象并返回
    }

}
