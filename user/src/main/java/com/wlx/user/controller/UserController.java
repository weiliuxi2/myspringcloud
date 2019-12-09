package com.wlx.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wlx.user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("user")
public class UserController {

    public UserController(){
        System.out.println("uuuuuuuuuu");
    }

    @Autowired
    OrderService orderService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/aa")
    @HystrixCommand(fallbackMethod = "myFallBack")
    public String userIndex(){
        System.out.println("user!!!!!!!!!!");
        return orderService.getOrderIndex();
    }

    @GetMapping("/bb")
    @HystrixCommand(fallbackMethod = "myFallBack2",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000")
    })
    public String bb(){
            return restTemplate.getForObject("http://order-server/order/index", String.class);
    }

    public String myFallBack(){
        return "系统正在维护，请稍后！";
    }

    public String myFallBack2(){
        return "系统正在维护，请稍后22BBBB！";
    }
}
