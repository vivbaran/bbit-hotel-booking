package com.bbit.app.bbithotelbooking.util;

public class Queries {
	
	// Queries for USER
	
	public static final String GET_EMP_BY_ID = "SELECT NAME FROM EMP WHERE ID = :id";
	
	public static final String INSERT_EMPLOYEE = "INSERT INTO EMP(id, name, age) VALUES(:id, :name, :age)";
	
	public static final String INSERT_USER = "INSERT INTO USER(FIRST_NAME, LAST_NAME, AGE, MOBILE_NUMBER, CITY, EMAIL, GENDER, IS_ADMIN, PASSWORD) VALUES(:firstName, :lastName, :age, :mobileNumber, :city, :email, :gender, :isAdmin, :password)";
	
	public static final String GET_PASSWORD_BY_EMAIL = "SELECT PASSWORD FROM USER WHERE EMAIL = :email";
	
	public static final String GET_USER_BY_EMAIL = "SELECT * FROM USER WHERE EMAIL = :email";
	 
	public static final String UPDATE_USER = "UPDATE USER SET FIRST_NAME = :firstName, LAST_NAME = :lastName, AGE = :age, MOBILE_NUMBER = :mobileNumber, GENDER = :gender, CITY = :city, IS_ADMIN = :isAdmin, PASSWORD = :password WHERE email = :email";
	
	public static final String DELETE_USER_BY_EMAIL = "DELETE FROM USER WHERE email = :email";
	
	// Queries for HOTEL
	
	public static final String INSERT_HOTEL = "INSERT INTO hotel(HOTEL_NAME, ADDRESS, CITY, COUNTRY) VALUES(:hotelName, :address, :city, :country)";
	
	public static final String Get_Hotel_By_Name = "SELECT * FROM hotel WHERE HOTEL_NAME = :hotelName";
	
	public static final String UPDATE_HOTEL_DETAILS = "UPDATE hotel SET HOTEL_NAME = :hotelName, ADDRESS = :address, CITY = :city, COUNTRY = :country WHERE HOTEL_NAME = :hotelName";

	public static final String DELETE_HOTEL_BY_NAME = "DELETE FROM hotel WHERE HOTEL_NAME = :hotelName";
	
	public static final String SEARCH_HOTELS_BY_CITY = "SELECT * FROM hotel WHERE CITY = :city";
	
	// Queries for BOOKING
	
	public static final String INSERT_BOOKINGS = "INSERT INTO booking(BOOKING_ID, HOTEL_NAME, EMAIL, CHECKIN_DATE, CHECKOUT_DATE) VALUES (:bookingId, :hotelName, :email, :checkinDate, :checkoutDate)";
	
	public static final String GET_BOOKING_BY_EMAIL = "SELECT * FROM booking WHERE EMAIL = :email";
	
	public static final String UPDATE_BOOKING_DETAILS = "UPDATE booking SET HOTEL_NAME = :hotelName, EMAIL = :email, CHECKIN_DATE = :checkinDate, CHECKOUT_DATE = :checkoutDate WHERE EMAIL = :email";
	
	public static final String DELETE_BOOKING = "DELETE FROM booking WHERE EMAIL = :email";
	
	//Queries for ROOMS
	
	public static final String INSERT_ROOM = "INSERT INTO room (ROOM_NUMBER, ROOM_TYPE, ROOM_PRICE, HOTEL_NAME) VALUES (:roomNumber, :roomType, :roomPrice, :hotelName)";
	
    public static final String GET_ROOMS_BY_HOTEL_NAME = "SELECT * FROM room WHERE HOTEL_NAME = :hotelName";
    
    public static final String UPDATE_ROOM_BY_HOTEL_NAME = "UPDATE room SET ROOM_TYPE = :roomType, ROOM_PRICE = :roomPrice WHERE HOTEL_NAME = :hotelName";
;
    
    public static final String DELETE_ROOMS_BY_HOTEL_NAME_AND_ROOM_NUMBER = "DELETE FROM room WHERE HOTEL_NAME = :hotelName AND ROOM_NUMBER = :roomNumber";


}

