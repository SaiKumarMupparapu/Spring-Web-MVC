package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;
import java.util.List;



public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByEmailAndPswd(String email, String pswd);
	
	User findByEmail(String email);

}
