package com.example.OrderServiceExam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OrderServiceExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceExamApplication.class, args);
	}
}





