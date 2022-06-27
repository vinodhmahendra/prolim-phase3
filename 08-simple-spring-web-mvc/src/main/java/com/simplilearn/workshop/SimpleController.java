package com.simplilearn.workshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/showMessage.html")
public class SimpleController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		ModelAndView modelAndView = new ModelAndView();
		
		//set the logical view name
//		modelAndView.setViewName("showMessage"); // logical view name
		
		//set the model data
		modelAndView.addObject("message", "Spring MVC! Configured Properly"); // model data
		
		return modelAndView;
	}

}
