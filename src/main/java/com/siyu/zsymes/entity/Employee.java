package com.siyu.zsymes.entity;

import lombok.Data;

/**
 * @author SiYu
 */
@Data
public class Employee {
    /**
     * 主键，用户ID
     */
    private String userid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String sex;
    /**
     * 地址
     */
    private String address;
    /**
     * 电话
     */
    private String tell;
    /**
     * 身份证
     */
    private String idcard;
    /**
     * 创建时间
     */
    private String createtime;
}
