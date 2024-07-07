package com.example.demo_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOrderApplication.class, args);
	}

}
