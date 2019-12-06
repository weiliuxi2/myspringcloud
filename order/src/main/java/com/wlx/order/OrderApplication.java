package com.wlx.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OrderApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello world3333333333";
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
