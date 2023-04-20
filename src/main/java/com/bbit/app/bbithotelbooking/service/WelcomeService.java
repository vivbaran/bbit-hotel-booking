package com.bbit.app.bbithotelbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbit.app.bbithotelbooking.dto.Employee;
import com.bbit.app.bbithotelbooking.repository.WelcomeRepository;

@Service
public class WelcomeService {

	@Autowired
	public WelcomeRepository welcomeRepository;

	public String getWelcomeUser() {
		return welcomeRepository.getWelcomeUser();
	}

	public void createEmployee(Employee employee) {
		welcomeRepository.createEmployee(employee);
		
	}

}
