package com.bbit.app.bbithotelbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bbit.app.bbithotelbooking.dto.User;
import com.bbit.app.bbithotelbooking.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		
		loginService.register(user);
		return "User Created Successfully -" + user.getFirstName() +" " + user.getLastName();
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody User user) {
		
		return loginService.login(user);
	}

}
