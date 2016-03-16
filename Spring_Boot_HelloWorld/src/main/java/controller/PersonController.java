package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Person;

@Controller
public class PersonController {
	@RequestMapping("/person")
	public String person(Model model) {
		Person p = new Person();
		p.setFirstName("Dheeraj");
		p.setLastName("Kumar");
		p.setAge(26);
		model.addAttribute("person", p);
		return "personview";
	}
	
	@ResponseBody
	@RequestMapping
	String Hello() {
		return "Hello World from Spring Boot";
	}
	
}