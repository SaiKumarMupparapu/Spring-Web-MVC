package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService pService;

	@GetMapping("/")
	public ModelAndView loadForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("prdObj", new Product());
		mav.setViewName("index");
		return mav;
	}

	@PostMapping("/product")
	public ModelAndView saveProduct(Product p) {
		ModelAndView mav = new ModelAndView();
		Boolean saveProduct = pService.saveProduct(p);

		if (saveProduct)
			mav.addObject("Smsg", "Product saved");
		else
			mav.addObject("Emsg", "Product Not saved");

		mav.addObject("prdObj", new Product());
		mav.setViewName("index");
		return mav;
	}

//	
	@GetMapping("/prds")
	public ModelAndView getAllProducts(
		@RequestParam(defaultValue = "0") int page,
		@RequestParam(defaultValue = "5") int size) {
		Page<Product> prds = pService.getPrdByPagination(PageRequest.of(page, size));
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageOfPrds",prds );
		mav.addObject("currentPage",page );
		mav.addObject("totalPages",prds.getTotalElements());
		mav.addObject("count",prds.getNumber());
		mav.setViewName("data");
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deletePrroduct(@PathVariable("id") Integer id) {
		pService.deleteProduct(id);
//		pService.deleteProduct(Integer.valueOf(id));
		ModelAndView mav= new ModelAndView();
		mav.setViewName("redirect:/prds");
		return mav;
	}
	@GetMapping("/editPrd/{id}")
	public ModelAndView editPrd(@PathVariable("id") Integer id) {
		Product p = pService.getPrdById(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("prdObj",p);
		mav.setViewName("index");
		return mav;
	}
	@PostMapping("/updatePrd")
	public ModelAndView updatePrd(@ModelAttribute Product p) {
		pService.saveProduct(p);
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "product updated");
		mav.setViewName("data");
		return mav;
	}

}
