package com.example.demo_notif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoNotifApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoNotifApplication.class, args);
	}

}
