package com.bbit.app.bbithotelbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbit.app.bbithotelbooking.dto.User;
import com.bbit.app.bbithotelbooking.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	
	public void register(User user) {
		loginRepository.register(user);
	}

	public String login(User user) {
				
		String userPassword = loginRepository.checkUserLoginPassword(user.getEmail());
		if(userPassword.equals(user.getPassword())) {
			return "Logged In Successfully";
		} else {
			return "Invalid Email or Passsword";
		}
		
	}
	
	public User getUserByEmail(String email) {
	    return loginRepository.getUserByEmail(email);
	}
	
	 public void updateUser(User user) {
	        loginRepository.updateUser(user);
	    }
	 
	 public void deleteUserByEmail(String email) {
		    loginRepository.deleteUserByEmail(email);
		}

}
