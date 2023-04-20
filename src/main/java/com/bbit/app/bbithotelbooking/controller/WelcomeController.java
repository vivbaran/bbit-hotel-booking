package com.bbit.app.bbithotelbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bbit.app.bbithotelbooking.dto.Employee;
import com.bbit.app.bbithotelbooking.service.WelcomeService;

@RestController
public class WelcomeController {
	
	@Autowired
	public WelcomeService welcomeService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return welcomeService.getWelcomeUser();
	}
	
	@PostMapping("/create")
	public String createEmp(@RequestBody Employee employee) {
		
		welcomeService.createEmployee(employee);
		return "Employee created successfully";
	}
}
