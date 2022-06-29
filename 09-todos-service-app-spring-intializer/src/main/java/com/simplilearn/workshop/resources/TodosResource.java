package com.simplilearn.workshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodosResource {
	
	//HTTP Method : GET
	//URI : /hello
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String helloWorld() {
		return "Hello World,Spring Boot";
	}
	

}
