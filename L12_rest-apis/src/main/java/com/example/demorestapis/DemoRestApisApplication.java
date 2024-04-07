package com.example.demorestapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoRestApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestApisApplication.class, args);
		System.out.println("thread = " + Thread.currentThread());
	}

}
