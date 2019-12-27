package com.wlx.swagger.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Service1 {

    public void makeException(){

        List list = new ArrayList<>();
        list.get(10);
    }
}
