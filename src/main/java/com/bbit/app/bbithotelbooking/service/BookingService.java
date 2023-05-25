package com.bbit.app.bbithotelbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbit.app.bbithotelbooking.dto.Booking;
import com.bbit.app.bbithotelbooking.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
    BookingRepository bookingRepository;

    public void createBooking(Booking booking) {
        bookingRepository.createBooking(booking);
    }
    
   
    public Booking getBookingByEmail(String email) {
    	return bookingRepository.getBookingByEmail(email);
    }
    
    
    public void updateBookingDetails(Booking booking) {
    	bookingRepository.updateBookingDetails(booking);
    }
    
    public void deleteBooking(String email) {
    	bookingRepository.deleteBooking(email);
    }

}
