package com.udemy.spring.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringCoreApplication.class, args);

		Laptop write =context.getBean(Laptop.class);
		write.code();
	}

}
