package com.tech.doks.spring;

public class HelloWorld {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void pringHello() {
		System.out.println(message + " from Spring 4");
	}
}