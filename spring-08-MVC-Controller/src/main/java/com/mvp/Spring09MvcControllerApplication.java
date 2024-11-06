package com.mvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;

//@SpringBootApplication(exclude = {AopAutoConfiguration.class})
@SpringBootApplication
public class Spring09MvcControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring09MvcControllerApplication.class, args);
	}

}
