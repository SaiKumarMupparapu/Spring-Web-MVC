package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
	
	@GetMapping("/greet")
	public String greetMsg(Model model) {
		model.addAttribute("msg","Good morning");		
		return "index";
	}

}
