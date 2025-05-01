package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.binding.User;

import jakarta.validation.Valid;

@Controller
public class UserController {
	@GetMapping("/")
	public String userForm(Model model) {
		model.addAttribute("userObj", new User());
		return "index";
	}

	@PostMapping("/user")
	public String handleUserForm(@Valid @ModelAttribute("userObj") User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "index";

		} else {
			model.addAttribute("msg", "user saved");			
			model.addAttribute("userObj", new User());
			return "index";
		}
	}

}
