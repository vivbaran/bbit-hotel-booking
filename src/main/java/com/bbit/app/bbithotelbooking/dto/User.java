package com.bbit.app.bbithotelbooking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User {

	public User(int id, String email, String password, String firstName, String lastName, String mobileNo, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.role = role;
	}

	private int id;	
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String role;

}
