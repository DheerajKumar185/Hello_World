package com.tech.doks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"controller","com.tech.doks"})
public class SpringBootDemoApplication {
	
	/*@ResponseBody
	@RequestMapping
	String Hello() {
		return "Hello World from Spring Boot";
	}
	
	@RequestMapping("/person")
	public String person(Model model) {
		Person p = new Person();
		p.setFirstName("Dheeraj");
		p.setLastName("Kumar");
		p.setAge(26);
		model.addAttribute("person", p);
		return "personview";
	}*/
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
