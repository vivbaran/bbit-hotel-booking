package com.bbit.app.bbithotelbooking.dto;

import lombok.Data;

@Data
public class User {
	
	private String firstName;
	private String lastName;
	private long mobileNumber;
	private int age;
	private String email;
	private String gender;
	private String city;
	private int isAdmin;
	private String password;

}
