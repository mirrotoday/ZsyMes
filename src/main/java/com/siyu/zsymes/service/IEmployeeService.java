package com.siyu.zsymes.service;

import com.siyu.zsymes.entity.Employee;
import com.siyu.zsymes.result.ApiResult;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author SiYu
 */
public interface IEmployeeService {
    /**
     * 插入数据
     * @param entity
     * @return
     */
    ApiResult<?> insert(Employee entity);
    int insertbatch(@Param("list") List<Employee> list);
    /**
     * 更新数据
     * @param entity
     * @return
     */
    int updateById(Employee entity);
    int updatebatch(@Param("list") List<Employee> list);

    int deleteBatchIds(@Param("coll") Collection<? extends Serializable> idList);
}
