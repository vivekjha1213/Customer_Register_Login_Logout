package com.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CustomerLoginLogoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerLoginLogoutApplication.class, args);
		Run();
	}


	public static void Run(){
		System.out.print("This App is Running on Server");
	}
}
