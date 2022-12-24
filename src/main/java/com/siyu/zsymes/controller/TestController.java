package com.siyu.zsymes.controller;

import com.siyu.zsymes.config.redis.RedisRepository;
import com.siyu.zsymes.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/login")
@Api(tags = "登录")
public class TestController {

    @Resource
    TestService testService;
    @Resource
    RedisRepository  redisRepository;

    @GetMapping(value = "/validate")
    @ApiOperation(value = "登录")
    public String Login(){
        redisRepository.set("user","ceshi");
        String key = redisRepository.get("user");
        System.out.println("====================进入登录"+key);
        return "登录";

    }
}
