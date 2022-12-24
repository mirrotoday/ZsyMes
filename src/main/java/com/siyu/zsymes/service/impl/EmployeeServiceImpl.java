package com.siyu.zsymes.service.impl;

import com.siyu.zsymes.entity.Employee;
import com.siyu.zsymes.mapper.EmployeeMapper;
import com.siyu.zsymes.result.ApiResult;
import com.siyu.zsymes.service.IEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author SiYu
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Resource
    EmployeeMapper employeeMapper;

    @Override
    public ApiResult<?> insert(Employee entity) {
        employeeMapper.insert(entity);
        return  new ApiResult<>().success(entity);
    }

    @Override
    public int insertbatch(List<Employee> list) {
        int count = 0;
        for(Employee employee:list){
            count++;
            employeeMapper.insert(employee);
        }
        return count;
    }

    @Override
    public int updateById(Employee entity) {
        return employeeMapper.updateById(entity);
    }

    @Override
    public int updatebatch(List<Employee> list) {
        int count = 0;
        for(Employee employee:list){
            count++;
            employeeMapper.updateById(employee);
        }
        return count;
    }

    @Override
    public int deleteBatchIds(Collection<? extends Serializable> idList) {
        return employeeMapper.deleteBatchIds(idList);
    }
}
