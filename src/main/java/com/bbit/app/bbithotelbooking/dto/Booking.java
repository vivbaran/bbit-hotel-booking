package com.bbit.app.bbithotelbooking.dto;

import lombok.Data;

@Data
public class Booking {
	
    private int bookingId;
    private String hotelName;
    private String email;
    private String checkinDate;
    private String checkoutDate;
    
}
