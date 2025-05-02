package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MsgController {
	
	@GetMapping("/greet")
	public String greetMsg(Model model) {
		model.addAttribute("msg", "Welcome to the Board");
		
		return"index";
	}

}
