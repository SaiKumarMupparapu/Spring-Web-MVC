package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
	
	public boolean saveUser(User user);
	public User getUser(String email,String pswd);
	public User getUserByEmail(String email);
	public boolean updateUser(User user) ;

	

}
