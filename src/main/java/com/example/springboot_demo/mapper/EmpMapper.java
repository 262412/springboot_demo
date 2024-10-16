package com.example.springboot_demo.mapper;

import com.example.springboot_demo.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
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

    //@Select("select * from emp")
    /*
     * 查询员工表中的所有记录
     *
     * 该方法通过注解@Select指定的SQL语句，查询emp表中的所有记录，并将结果映射为Emp对象的列表
     * 主要用于获取所有员工的信息，以便进行进一步的数据操作和处理
     *
     * @param name 员工姓名，可选参数，用于筛选查询结果
     * @param gender 员工性别，可选参数，用于筛选查询结果
     * @param begin 查询开始日期，可选参数，用于筛选查询结果
     * @param end 查询结束日期，可选参数，用于筛选查询结果
     * @return 返回包含所有员工记录的列表，如果表中没有记录，则返回空列表
     */
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
    /**
     * 删除指定ID列表对应的数据
     *
     * @param ids 要删除的数据的ID列表
     */
    void delete(List<Integer> ids);

    /**
     * 向系统中添加一个新的员工对象
     *
     * @param emp 要添加的员工对象
     */
    void add(Emp emp);
}
