package com.example.worldexplorer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.worldexplorer.entity.User;
import com.example.worldexplorer.services.Services;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class Controller {
	
	@Autowired
	private Services service;
	
	@GetMapping("/welcome")
	public String welcome() {
			return "Hello";
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable String id) {
	return this.service.getUser(Long.parseLong(id));
	}

	//register candidate
	@PostMapping("/register/candidate")
	public String registerUser(@RequestBody User user)
	{
	return this.service.registerUser(user);
	}


	//retrieve all users from the database
	@GetMapping("/users")
	public List<User> getUsers()
	{
	return this.service.getUsers();
	}

	@PostMapping("/login/candidates")
	public String loginUser(@RequestBody User user,HttpServletRequest request)
	{

	// UserRegistrationAndLogin userRegistrationAndLogin=userDao.findByEmailId(user.getEmailId());
	// long uid=userRegistrationAndLogin.getUserId();
	// request.getSession().setAttribute("uid", uid);
	return this.service.loginUser(user);

	}


}
