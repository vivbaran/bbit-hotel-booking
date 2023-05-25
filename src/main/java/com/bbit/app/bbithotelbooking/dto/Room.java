package com.bbit.app.bbithotelbooking.dto;

import lombok.Data;

@Data
public class Room {
	private int roomNumber;
	private String roomType;
	private int roomPrice;
	private String hotelName;
}
