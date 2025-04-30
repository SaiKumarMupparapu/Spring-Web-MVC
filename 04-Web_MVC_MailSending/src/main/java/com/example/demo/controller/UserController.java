package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.LoginDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl service;
	
	//register-get
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("userObj",new User());
		return "register";
	}
	//register-post
	
	@PostMapping("/register")
	public String registerHandler(@ModelAttribute User user, Model model) {
		boolean saveUser = service.saveUser(user);
		
		
		if(saveUser) {
			model.addAttribute("loginDto",new LoginDto());
			return "login";
		}else {
			model.addAttribute("userObj",new User());
			model.addAttribute("msg", "Email alredy exists");
			return "register";
		}		
		
				
	}
	
	//login -get
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginDto", new LoginDto());
		return "login";
	}
	//login-post
	@PostMapping("/login")
	public String loginHandler(@ModelAttribute LoginDto lDto, Model model) {
		
		User user = service.getUser(lDto.getEmail(), lDto.getPswd());
		
		if(user != null && user.getId()!=null) {
			model.addAttribute("user", user.getName());
			return "dashboard";
		}
		else {
			model.addAttribute("loginDto", new LoginDto());
			model.addAttribute("msg", "Invalid credintial");
			return "login";
			
		}		
		
	}
	
	//forgot pswd -get
	@GetMapping("/reset")
	public String pswdRest(Model model) {
		model.addAttribute("user", new User());
		return "reset";
	}
	@PostMapping("/reset")
	public String pswdRestHandler(@ModelAttribute User user , Model model) {
		User userByEmail = service.getUserByEmail(user.getEmail());
		if(userByEmail != null) {
			userByEmail.setPswd(user.getPswd());
			boolean updateUser = service.updateUser(userByEmail);
			if(updateUser) {
				model.addAttribute("loginDto", new LoginDto());
				return "login";	
						
		}
		}
			model.addAttribute("msg", "no user Found By this Email");
			return "reset";			
		
		
		
	}

	//forgot pswd -post
}
