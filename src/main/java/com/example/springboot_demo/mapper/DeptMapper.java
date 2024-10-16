package com.example.springboot_demo.mapper;

import com.example.springboot_demo.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
/**
 * DeptMapper接口，定义了与dept表相关的数据操作方法
 */
public interface DeptMapper {
    /**
     * 查询dept表中的所有数据
     *
     * @return 包含dept表中所有记录的列表
     */
    @Select("select * from dept")
    List<Dept> list();
}

