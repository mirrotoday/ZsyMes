package com.siyu.zsymes.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author SiYu
 */
@RestController
@RequestMapping(value = "/login")
@Api(tags = "登录")
public class TestController {

    @Resource
    RedisTemplate<String, Object> redisTemplate1;

    @GetMapping(value = "/validate")
    @ApiOperation(value = "登录")
    public String login(){
        redisTemplate1.opsForValue().set("user","张三");
       String emp = (String)redisTemplate1.opsForValue().get("user");
       //设置过期策略
        redisTemplate1.expire("user",10, TimeUnit.MINUTES);
        System.out.println("====================进入登录"+emp);
        return emp;
    }
}
