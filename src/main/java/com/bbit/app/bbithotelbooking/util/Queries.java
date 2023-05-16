package com.bbit.app.bbithotelbooking.util;

public class Queries {
	
	public static final String GET_EMP_BY_ID = "SELECT NAME FROM EMP WHERE ID = :id";
	
	public static final String INSERT_EMPLOYEE = "INSERT INTO EMP(id, name, age) VALUES(:id, :name, :age)";
	
	public static final String INSERT_USER = "INSERT INTO USER(FIRST_NAME, LAST_NAME, AGE, MOBILE_NUMBER, CITY, EMAIL, GENDER, IS_ADMIN, PASSWORD) VALUES(:firstName, :lastName, :age, :mobileNumber, :city, :email, :gender, :isAdmin, :password)";
	
	public static final String GET_PASSWORD_BY_EMAIL = "SELECT PASSWORD FROM USER WHERE EMAIL = :email";

}
