package com.sky.biz.sseries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("classpath:spring-multitenant-config.xml")
public class SseriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SseriesApplication.class, args);
	}
}
