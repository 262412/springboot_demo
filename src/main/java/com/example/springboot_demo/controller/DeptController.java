package com.example.springboot_demo.controller;

import com.example.springboot_demo.pojo.Dept;
import com.example.springboot_demo.pojo.Result;
import com.example.springboot_demo.service.DeptService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
//@Api(value = "部门信息", tags = "部门管理")
public class DeptController {
    // 注入DeptService接口的实现类，用于操作部门信息
    @Autowired
    private DeptService deptService;

    /**
    * 查询全部部门数据
    * 此方法用于响应查询所有部门数据的请求它将返回一个成功的响应结果，
    * 具体的部门数据需要通过调用此方法来获取
    *
    * @return 返回一个成功的Result统一格式对象，表示操作成功
    */
    @GetMapping
// @ApiOperation("查询全部部门数据")
    public Result list(){
    // 记录查询全部部门数据的日志
    log.info("查询全部部门数据");
    // 调用部门服务的list方法获取所有部门数据列表
    List<Dept> deptList = deptService.list();
    // 返回一个成功的Result对象，包含部门数据列表
    return Result.success(deptList);
    }

    /**
     * 根据部门ID删除部门信息
     *
     * @param id 部门ID，用于标识特定的部门
     * @return 返回操作结果，包含成功与否的信息
     */
    @DeleteMapping("/{id}")
    public  Result delete(@PathVariable Integer id){
        // 记录删除部门的日志，包括部门ID
        log.info("根据id删除部门:{}", id);
        // 调用部门服务的删除方法，传入部门ID执行删除操作
        deptService.delete(id);
        // 返回成功结果
        return Result.success();
    }
    /**
     * 添加新部门
     * 该方法用于接收一个部门对象，并将其添加到系统中它展示了如何通过HTTP POST请求来新增部门，
     * 并使用部门服务将部门信息保存到数据库中
     *
     * @param dept 通过请求体传递的部门对象，包含部门的相关信息
     * @return 返回一个表示操作成功的Result对象，包含状态码和消息
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        // 记录日志，用于审计和跟踪部门信息的添加
        log.info("新增部门:{}", dept);
        // 调用部门服务的添加方法，将部门信息保存到数据库中
        deptService.add(dept);
        // 返回操作成功的结果
        return Result.success();
    }
}
