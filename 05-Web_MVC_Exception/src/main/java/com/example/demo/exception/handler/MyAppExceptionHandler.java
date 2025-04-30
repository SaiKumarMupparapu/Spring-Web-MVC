package com.example.demo.exception.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyAppExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String exHandler(Exception e ,Model model) {
		model.addAttribute("eMsg", e.getLocalizedMessage());
		return "index";
	}
}
