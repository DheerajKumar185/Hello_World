package com.tech.doks.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("spring.xml");
			HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
			helloWorld.pringHello();
		} finally {
			context.close();
		}
	}
}