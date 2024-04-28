package com.example.demodb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoDbApplication {

//	int num;
//	static int num2;
//
//	public void func(int a, int b){
//		System.out.println("a = " + a + ", b = " + b);
//		a = a + 10;
//		b = b + 10;
//		System.out.println("a = " + a + ", b = " + b);
//	}
//
//	public void func2(final int a, final int b){
//		System.out.println("a = " + a + ", b = " + b);
////		a = a + 10;
////		b = b + 10;
////		System.out.println("a = " + a + ", b = " + b);
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoDbApplication.class, args);

////		DemoDbApplication demoDbApplication = new DemoDbApplication();
////		demoDbApplication.func2(10, 20);
//
//		// method arguments
//		// member variables
//		// class variables
//
//		Book dbook = new Book();
//		dbook.setId(10);
//
//
//		Book.BookBuilder bookFromBuilder = Book.builder()
//				.id(10)
//				.name("History of Panipat")
//				.authorEmail("Kabirdas");
////				.build();
//
//		/**
//		    1. Internally this is also using parameterized constructor but the end user does not have to
//		      take the pain of defining all the attributes
//		 	2. You don't have to pass the default values for the non required attributes
//
//		 **/
//
//
//		Book newBook = new Book();
//
//
//		Book book = new Book(1, "Intro to Java", "Peter",
//				Genre.FICTIONAL, "Ireland", "peter@gmail.com", new Date(), new Date());
//
//		Book book2 = new Book(2, "Intro to Python", "Robert",
//				Genre.FICTIONAL, "robert@gmail.com", "Poland", new Date(), new Date());
//
//		Book book3 = new Book(3, "Book_3", null,
//				null, null, null, null, null);
//
//		System.out.println("book1 = " + book);
//		System.out.println("book2 = " + book2);
//
//
//		System.out.println("book2 = " + book2);
//
//		bookFromBuilder.authorEmail("peter@yahoo.co.in")
//				.build();

//		book.getId();
//		book.setId(10);
	}

}
