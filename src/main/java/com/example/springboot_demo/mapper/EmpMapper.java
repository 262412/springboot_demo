package com.example.springboot_demo.mapper;

import com.example.springboot_demo.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
 * 员工管理
 */
/**
 * 映射员工表的Mapper接口
 * 本接口用于定义与员工表相关的数据访问方法
 */
@Mapper
public interface EmpMapper {

    //@Select("select count(*) from emp")
    //public Long count();

    //@Select("select * from emp limit 0,5")
    //public List<Emp> page(Integer start, Integer pageSize);

    @Select("select * from emp")
    public List<Emp> list();

}
