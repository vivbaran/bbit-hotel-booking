package com.bbit.app.bbithotelbooking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Room {
	
	public Room(int id, int number, String type, int price) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.price = price;
	}
	private int id;
	private int number;
	private String type;
	private int price;
	private int hotelId;
}
