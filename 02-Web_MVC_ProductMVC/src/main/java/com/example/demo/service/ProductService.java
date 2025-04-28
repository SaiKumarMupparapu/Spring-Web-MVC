package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	public Boolean saveProduct(Product p) {
		 Product product = repo.save(p);
		 return product==null?false:true;
	}
	
	public List<Product> getProducts(){
		return repo.findAll();
	}
	public void deleteProduct(int id) {
		  repo.deleteById(id);
	}
	public Product getPrdById(int id) {
		 Optional<Product> p = repo.findById(id);
		 return p.get();
		
	}
	public int recordsCount() {
		return (int)repo.count();
	}
	
	public Page<Product>getPrdByPagination(Pageable pageable){
		 return repo.findAll(pageable);
	}

}
