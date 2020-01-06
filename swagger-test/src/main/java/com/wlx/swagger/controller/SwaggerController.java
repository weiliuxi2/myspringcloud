package com.wlx.swagger.controller;

import com.wlx.swagger.model.LoginForm;
import com.wlx.swagger.service.Service1;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(description = "用户操作接口")
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @Autowired
    Service1 service1;

    @GetMapping()
    @ApiOperation(value = "查看成交数据管理表信息11", tags = "1234455")
    @ApiResponses({
            @ApiResponse(message = "成交数据管理表信息数据2222", code = 209)
    })
    //@ApiImplicitParam(name = "telephone", value = "电话号码", paramType = "query", required = true, dataType = "String")
    public String test1(LoginForm form){
        return  "ok123456";
    }

    @GetMapping("/test2")
    @ApiOperation(value = "qqqq", tags = "bbbbb",response = LoginForm.class)
    @ApiResponses({
            @ApiResponse(message = "sccccc", code = 200)
    })
    public String test2(LoginForm form){
        service1.makeException();
        return  "ok123456";
    }
}
