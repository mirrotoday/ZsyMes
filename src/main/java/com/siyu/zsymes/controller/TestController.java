package com.siyu.zsymes.controller;

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

    @GetMapping(value = "/validate")
    @ApiOperation(value = "登录")
    public String Login(){
        System.out.println("====================进入登录");
        return "登录";

    }
}
