package com.bbit.app.bbithotelbooking.service;

import java.util.List;

import com.bbit.app.bbithotelbooking.dto.User;

public interface UserService {

	// creates user
	public User createUser(User user);

	// check if email already exists in database
	public boolean checkEmail(String email);
	
	// get user by email
	public User getUserByEmail(String email) throws Exception;
	
	// get all users
	public List<User> getAllUsers();

	// updates an existing user
	public void updateUser(String email, User user);
	
	// delete user
	public void deleteUser(String email);

}
