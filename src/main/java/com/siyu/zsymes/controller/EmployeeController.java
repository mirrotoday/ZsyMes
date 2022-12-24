package com.siyu.zsymes.controller;

import com.siyu.zsymes.entity.Employee;
import com.siyu.zsymes.result.ApiResult;
import com.siyu.zsymes.service.IEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author SiYu
 */
@RestController
@RequestMapping(value = "/emp")
@Api(tags = "操作用户")
@Slf4j
public class EmployeeController {
    @Resource
    IEmployeeService employeeService;

    @PostMapping("/addNew")
    @ApiOperation("用户新增")
    public ApiResult<?> addNewPerson(@RequestBody Employee employee){
        log.info("新增成功");
        return  employeeService.insert(employee);
    }
    @PostMapping("/addNew-batch")
    @ApiOperation("用户批量新增")
    public void addNewBatchPerson(@RequestBody List<Employee> employee){
        employeeService.insertbatch(employee);
        log.info("用户批量新增");
    }

    @PostMapping("/update")
    @ApiOperation("用户更新")
    public void updatePerson(@RequestBody Employee employee){
        employeeService.updateById(employee);
        log.info("更新成功");
    }
    @PostMapping("/update-batch")
    @ApiOperation("批量更新")
    public void updateBatchPerson(@RequestBody  List<Employee> employee){
        employeeService.updatebatch(employee);
        log.info("批量更新成功");
    }
    @PostMapping("/delete-batch")
    @ApiOperation("批量删除")
    public void deleteBatchByPersonId(@RequestBody  List<String> employee){
        employeeService.deleteBatchIds(employee);
        log.info("批量删除成功");
    }
}
