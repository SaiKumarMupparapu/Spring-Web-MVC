package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/greet")
	public String greet(Model model) {
//		int i=10/0;
		String n=null;
		n.length();
		model.addAttribute("msg","Good morning");
		return "index";
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public String exHandler(NullPointerException n, Model model) {
		model.addAttribute("msg",n.getLocalizedMessage());
		return "index";
	}

}
