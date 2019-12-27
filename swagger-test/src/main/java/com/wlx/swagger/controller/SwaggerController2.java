package com.wlx.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户操作接口2222")
@RestController
@RequestMapping("/swagger")
public class SwaggerController2 {

    @GetMapping("/user/")
    @ApiImplicitParam(name = "telephone", value = "电话号码", paramType = "query", required = true, dataType = "String")
    public String test1(@RequestParam String telephone){

        return telephone + "ok123456";
    }
}
