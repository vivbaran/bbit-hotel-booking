package com.bbit.app.bbithotelbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		return "Created Successfully -" + user.getFirstName() +" " + user.getLastName();
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody User user) {
		
		return loginService.login(user);
	}
	
	 @GetMapping("/user/{email}")
	    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
	        User user = loginService.getUserByEmail(email);
	        if (user != null) {
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
	 @PutMapping("/user/{email}")
	    public ResponseEntity<String> updateUser(@PathVariable("email") String email, @RequestBody User user) {
	        User existingUser = loginService.getUserByEmail(email);
	        if (existingUser != null) {
	      
	            existingUser.setFirstName(user.getFirstName());
	            existingUser.setLastName(user.getLastName());
	            existingUser.setAge(user.getAge());
	            existingUser.setMobileNumber(user.getMobileNumber());
	            existingUser.setGender(user.getGender());
	            existingUser.setCity(user.getCity());
	            existingUser.setIsAdmin(user.getIsAdmin());
	            existingUser.setEmail(user.getEmail());
	            existingUser.setPassword(user.getPassword());
	            
	            loginService.updateUser(existingUser);
	            
	            return ResponseEntity.ok("Updated Successfully -\n"
	                    + "First Name: " + user.getFirstName() + "\n"
	                    + "Last Name: " + user.getLastName() + "\n"
	                    + "Age: " + user.getAge() + "\n"
	                    + "Mobile Number: " + user.getMobileNumber() + "\n"
	                    + "Gender: " + user.getGender() + "\n"
	                    + "City: " + user.getCity() + "\n"
	                    + "Is Admin: " + user.getIsAdmin() + "\n"
	                    + "Password: " + user.getPassword() + "\n"
	            		+ "Email: " + user.getEmail());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
	 @DeleteMapping("/user/{email}")
	 public ResponseEntity<String> deleteUserByEmail(@PathVariable("email") String email) {
	     loginService.deleteUserByEmail(email);
	     return ResponseEntity.ok("Deleted Successfully");
	 }

}
