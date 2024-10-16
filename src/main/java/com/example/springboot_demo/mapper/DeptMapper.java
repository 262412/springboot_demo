package com.example.springboot_demo.mapper;

import com.example.springboot_demo.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
/*
  DeptMapper接口，定义了与dept表相关的数据操作方法
 */
public interface DeptMapper {
    /**
     * 查询dept表中的所有数据
     *
     * @return 包含dept表中所有记录的列表
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据部门ID查找部门信息
     *
     * @param id 部门ID，用于定位特定的部门信息
     * @return 返回对应的部门信息对象，如果找不到则返回null
     */
    @Select("select * from dept where id = #{id}")
    Dept findById(Integer id);

    /**
     * 根据部门ID删除部门信息
     * 此方法使用MyBatis的注解@Delete，指定删除操作的SQL语句
     * 通过传入部门ID，执行SQL语句来删除对应的部门信息
     *
     * @param id 部门ID，用于标识要删除的部门
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 使用动态SQL插入语句插入一个部门对象
     *
     * @param dept 要插入的部门对象，包含name, createTime, updateTime属性
     */
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    /**
     * 更新部门信息
     *
     * @param dept 需要更新的部门对象，包含部门的id和新的名称
     */
    @Update("update dept set name = #{name} where id = #{id}")
    void update(Dept dept);
}
