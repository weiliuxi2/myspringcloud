package com.wlx.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(name = "order-server")
public interface OrderService {

    @GetMapping("/order/index")
    String getOrderIndex();


}
