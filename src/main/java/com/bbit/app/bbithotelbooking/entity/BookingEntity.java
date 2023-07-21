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
@Entity
@Table(name = "BOOKING")
public class BookingEntity {
	
	public BookingEntity(int roomId, LocalDate checkinDate, LocalDate checkoutDate, String firstName, String lastName,String email) {
		super();
		this.roomId = roomId;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ROOM_ID")
	private int roomId;
	
	@Column(name = "CHECKIN_DATE")
	private LocalDate checkinDate;
	
	@Column(name = "CHECKOUT_DATE")
	private LocalDate checkoutDate;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "BOOKING_STATUS")
	private String bookingStatus;
	
}
