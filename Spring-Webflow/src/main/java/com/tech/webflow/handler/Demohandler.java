package com.tech.webflow.handler;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.tech.webflow.bean.UserBean;
 
@Component
public class Demohandler {
 
	public UserBean initFlow(){
		return new UserBean();
	}
 
	public String validateDetails(UserBean userBean,MessageContext messageContext){
		String status = "success";
		if(userBean.getName().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"name").defaultText("Name cannot be Empty").build());
			status = "failure";
		}
		if(userBean.getAddress().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"address").defaultText("Address cannot be Empty").build());
			status = "failure";
		}
		if(userBean.getCompany()==null){
			messageContext.addMessage(new MessageBuilder().error().source(
					"company").defaultText("Company cannot be Empty").build());
			status = "failure";
		}
		return status;
	}
}