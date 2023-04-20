package com.bbit.app.bbithotelbooking.dto;

import java.util.List;

import lombok.Data;

@Data
public class Room {
	
	private int id;
	private String type;
	private String price;
	private List<String> facility;

}
