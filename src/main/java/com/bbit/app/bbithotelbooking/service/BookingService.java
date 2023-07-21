package com.bbit.app.bbithotelbooking.service;

import java.util.List;

import com.bbit.app.bbithotelbooking.dto.Booking;

public interface BookingService {
	
	public Booking createBooking(int roomId, Booking booking);
    
	public Booking getBookingById(int id) throws Exception;
    
	public List<Booking> getAllBookings();
    
	public Booking updateBooking(int id, Booking booking);
    
	public void deleteBooking(int id);

}
