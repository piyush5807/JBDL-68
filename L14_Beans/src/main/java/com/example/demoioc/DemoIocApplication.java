package com.example.demoioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoIocApplication {



	DemoIocApplication(){
		System.out.println("inside constructor, a = " + this.a + ", b = " + this.b);
		this.b = "abc";
	}

	private int a = 10;
	private String b;

	public void test(){
		System.out.println("a = " + this.a + ", b = " + this.b);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoIocApplication.class, args);

//		DemoIocApplication o = new DemoIocApplication();

	}

}
