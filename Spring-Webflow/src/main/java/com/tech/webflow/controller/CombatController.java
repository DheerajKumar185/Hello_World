package com.tech.webflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CombatController {

	@RequestMapping("home")
	public String home(){
		return "index";
	}
}