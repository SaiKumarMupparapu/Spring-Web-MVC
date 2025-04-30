package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.exception.handler.ProductNotFound;

@Controller
public class ProductController {

	@GetMapping("/prd/{id}")
	private String product(@PathVariable("id") int id, Model model) throws Exception {
		if(id>10) {
			try {
				throw new ProductNotFound("invalid product id");
				
			} catch (ProductNotFound p) {
				throw new ProductNotFound("invalid product id");
				
			}
		}
		model.addAttribute("msg", "Apple product");
		
		return"index";
	}
	
	
}
