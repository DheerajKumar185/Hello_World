package com.tech.doks.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("spring.xml");
			HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
			helloWorld.setMessage("I'm Object A");
			helloWorld.pringHello();
			HelloWorld helloWorld1 = (HelloWorld) context.getBean("helloWorld");
			helloWorld1.pringHello();
		} finally {
			context.close();
		}
	}
}