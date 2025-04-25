package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MsgController {

	@GetMapping("/greet")
	public ModelAndView getMsg2() {
		ModelAndView mv = new ModelAndView();

		mv.addObject("msg", "Good afterNoon");
		mv.setViewName("index");

		return mv;

	}

	@GetMapping("/welcome")
	public ModelAndView getMsg1() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "Welcome ....");
		mv.setViewName("index");
		return mv;
	}
}
