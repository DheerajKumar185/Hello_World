package com.tech.doks.spring;

import org.springframework.beans.factory.BeanNameAware;

public class HelloWorld implements BeanNameAware {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void pringHello() {
		System.out.println(message + " from Spring 4");
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean Name is : " + beanName);
		
	}
}