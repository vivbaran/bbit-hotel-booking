package com.bbit.app.bbithotelbooking.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ROOM")
@Entity
public class RoomEntity {

	public RoomEntity(int hotelId, int number, String type, int price) {
		super();
		this.hotelId = hotelId;
		this.number = number;
		this.type = type;
		this.price = price;
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "HOTEL_ID")
	private int hotelId;
	
	@Column(name = "NUMBER")
	private int number;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "PRICE")
	private int price;

}
