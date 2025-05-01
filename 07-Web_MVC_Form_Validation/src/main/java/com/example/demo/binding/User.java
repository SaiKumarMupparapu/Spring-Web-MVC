package com.example.demo.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User {
	
	@NotEmpty(message = "Name is required")
	@Size(min=3,max=10,message="min 3 and max 10 characters allowed")
	private String name;

	    @NotEmpty(message = "Email is required")
	    @Email(message = "Invalid email format")
	    private String email;
	
	@NotNull(message = "Enter mobile number")
	private Long phno;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phno=" + phno + "]";
	}
	
	

}
