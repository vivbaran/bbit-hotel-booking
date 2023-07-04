package com.bbit.app.bbithotelbooking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Room {
	
	public Room(int id, int number, String type, int price, int hotelId) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.price = price;
		this.hotelId = hotelId;
	}
	public int id;
	public int number;
	public String type;
	public int price;
	public int hotelId;
	public String status;
}
