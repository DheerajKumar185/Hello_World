package com.tech.webflow.bean;

import java.io.Serializable;

public class UserBean implements Serializable{
	 
	private static final long serialVersionUID = 4657462015039726030L;
	private String name;
	private String address;
	private String company;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	} 
}