package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@GetMapping("/user/{id}")
	@ResponseBody
	public String pathParam(@PathVariable("id") int id) {
		String msg;
		if (id > 10)
			msg = "User Name is sai";
		else
			msg = "user not found";
		return msg;
	}

	@GetMapping("/quer")
	@ResponseBody
	public String queryParam(
			@RequestParam("name")String name,
			@RequestParam("id") int id) {
				return "Name :"+name +"\n id : "+id;
	}
}
