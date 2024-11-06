package com.spring.spring_07_SpringBoot_Demo;

import com.spring.spring_07_SpringBoot_Demo.config.AppConfigData;
import com.spring.spring_07_SpringBoot_Demo.config.DBConfigData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring07SpringBootDemoApplication {


	public static void main(String[] args) {

		ApplicationContext container=SpringApplication.run(Spring07SpringBootDemoApplication.class,args);
		//this for creation of a container

		String str= container.getBean(String.class);
		AppConfigData container2= container.getBean(AppConfigData.class);

		System.out.println("container2.getPassword() = " + container2.getPassword());
		System.out.println("container2.getUrl() = " + container2.getUrl());
		System.out.println("container2.getUsername() = " + container2.getUsername());

		System.out.println(str);

		DBConfigData db=container.getBean(DBConfigData.class);

		System.out.println("db.getPassword() = " + db.getPassword());
		System.out.println("db.getUsername() = " + db.getUsername());
		System.out.println("db.getType() = " + db.getType());


	}




	@Bean
	public String str1(){
		return"Spring Project";
	}

}
