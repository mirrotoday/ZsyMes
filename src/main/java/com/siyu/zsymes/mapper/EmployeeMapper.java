package com.siyu.zsymes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.siyu.zsymes.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author SiYu
* @description 针对表【employee】的数据库操作Mapper
* @createDate 2022-12-24 20:28:13
* @Entity com.siyu.zsymes.entity.Test.Employee
*/
@Mapper
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

}




