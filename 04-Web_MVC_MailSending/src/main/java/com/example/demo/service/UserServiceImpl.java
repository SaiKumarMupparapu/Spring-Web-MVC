package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.utils.EmailUtil;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;
	@Autowired
	private EmailUtil email;

	@Override
	public boolean saveUser(User user) {
		if (repo.findByEmail(user.getEmail()) == null) {
			User saved = repo.save(user);
			String mail = user.getEmail();
			String subject = "Congratulations Your Account created";
			String body = "<h1 style='color:green'> Welcome to the club</h1>";


			if (saved.getId() != null) {
				return email.sendMail(mail, subject, body);
			}

		}
		return false;

	}

	@Override
	public User getUser(String email, String pswd) {
		return repo.findByEmailAndPswd(email, pswd);
	}

	@Override
	public User getUserByEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public boolean updateUser(User user) {
		User save = repo.save(user);
		return save.getId()!=null ? true: false;
	}

}
