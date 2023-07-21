package com.bbit.app.bbithotelbooking.dto;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Booking {
	
	public Booking(int id, int roomId, LocalDate checkinDate, LocalDate checkoutDate, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public int id;
    public int roomId;
	public LocalDate checkinDate;
    public LocalDate checkoutDate;
    public String firstName;
    public String lastName;
    private String email;
    public String bookingStatus;
}
