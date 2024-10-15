package com.example.springboot_demo.controller;

import com.example.springboot_demo.pojo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/deps")
@Api(value = "部门信息", tags = "部门管理")
public class DeptController {

    /**
     * 查询全部部门数据
     * 此方法用于响应查询所有部门数据的请求它将返回一个成功的响应结果，
     * 具体的部门数据需要通过调用此方法来获取
     *
     * @return 返回一个成功的Result统一格式对象，表示操作成功
     */
    @RequestMapping("/search")
    @ApiOperation("查询全部部门数据")
    public Result list(){
        log.info("查询全部部门数据");
        return Result.success();
    }

}
