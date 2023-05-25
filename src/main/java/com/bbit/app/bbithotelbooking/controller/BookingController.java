package com.bbit.app.bbithotelbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bbit.app.bbithotelbooking.dto.Booking;
import com.bbit.app.bbithotelbooking.service.BookingService;

@RestController
public class BookingController {
	@Autowired
    BookingService bookingService;
	
	@PostMapping("/bookings")
    public String createBooking(@RequestBody Booking booking) {
        bookingService.createBooking(booking);
        return "Booking Created Successfully -" + booking.getHotelName();
    }
	
	@GetMapping("/bookings/{email}")
	public ResponseEntity <Booking> getBookingByEmail(@PathVariable("email") String email, @RequestBody Booking booking) {
		Booking bookings = bookingService.getBookingByEmail(email);
		if (bookings != null ) {
			return ResponseEntity.ok(bookings);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/bookings/{email}")
	public ResponseEntity<String> updateBookingDetails(@PathVariable("email") String email, @RequestBody Booking booking) {
		Booking existingBooking = bookingService.getBookingByEmail(email);
		if(existingBooking != null) {
			existingBooking.setHotelName(booking.getHotelName());
			existingBooking.setEmail(booking.getEmail());
			existingBooking.setCheckinDate(booking.getCheckinDate());
			existingBooking.setCheckoutDate(booking.getCheckoutDate());
			
			bookingService.updateBookingDetails(existingBooking);
			
			return ResponseEntity.ok("Booking Updated Successfully -\n"
			        + "Hotel Name: " + booking.getHotelName() + "\n"
			        + "Email: " + booking.getEmail() + "\n"
			        + "Check-in Date: " + booking.getCheckinDate() + "\n"
			        + "Check-out Date: " + booking.getCheckoutDate());
        } else { 
            return ResponseEntity.notFound().build();
        }
	}
	
	@DeleteMapping("/bookings/{email}")
	public ResponseEntity<String> deleteBooking(@PathVariable("email") String email) {
		bookingService.deleteBooking(email);
		return ResponseEntity.ok("Booking Deleted Successfully");
	}
}
