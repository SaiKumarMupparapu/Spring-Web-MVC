package com.example.demo.util;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Contact;
import com.example.demo.repo.ContactRepo;

@Component
public class MyAppRunner implements ApplicationRunner {
	@Autowired
	private ContactRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Contact c1=new Contact();
		c1.setName("sai");
		c1.setNum(1234567890l);
		
		Contact c2=new Contact();

		c2.setName("shiva");
		c2.setNum(123456789l);
		
		repo.saveAll(Arrays.asList(c1,c2));
		
	}

}
