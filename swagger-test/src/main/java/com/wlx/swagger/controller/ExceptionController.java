package com.wlx.swagger.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptionProcess(Exception e){
        Map<String, Object> jsonResult = new HashMap<>();
        jsonResult.put("status", "qqq");
        jsonResult.put("message", "你妹啊，异常了");
        jsonResult.put("message2", e.getMessage());
        jsonResult.put("result", null);
        return JSON.toJSONString(jsonResult);
    }
}
