package com.bbit.app.bbithotelbooking.util;

public class Queries {
	
	public static final String GET_EMP_BY_ID = "SELECT NAME FROM EMP WHERE ID = :id";
	
	public static final String INSERT_EMPLOYEE = "INSERT INTO EMP(id, name, age) VALUES(:id, :name, :age)";

}
