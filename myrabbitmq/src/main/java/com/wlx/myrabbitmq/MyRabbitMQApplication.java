package com.wlx.myrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAspectJAutoProxy
public class MyRabbitMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyRabbitMQApplication.class,args);
    }
}
