package com.bbit.app.bbithotelbooking.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Hotel {
	
	public Hotel(int id, String name, String country, String city, String address, String contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.city = city;
		this.address = address;
		this.contactNo = contactNo;
	}
	private int id;
    private String name;
    private String country;
    private String city;
    private String address;
    private String contactNo;
    public List<Room> rooms;
    
    
}
