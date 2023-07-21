package com.bbit.app.bbithotelbooking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbit.app.bbithotelbooking.dto.Booking;
import com.bbit.app.bbithotelbooking.entity.BookingEntity;
import com.bbit.app.bbithotelbooking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Booking createBooking(int roomId, Booking booking) {
        if (booking.getCheckoutDate().isBefore(booking.getCheckinDate())) {
            throw new IllegalArgumentException("The Checkout date must be after the check-in date.");
        }

        BookingEntity bookingEntity = new BookingEntity(
            booking.getRoomId(),
            booking.getCheckinDate(),
            booking.getCheckoutDate(),
            booking.getFirstName(),
            booking.getLastName(),
            booking.getEmail()
        );
        
        bookingEntity = bookingRepository.saveAndFlush(bookingEntity);
        booking.setId(bookingEntity.getId());
        
        return booking;
    }


    @Override
    public Booking getBookingById(int id) throws Exception {
        BookingEntity bookingEntity = bookingRepository.findById(id).orElseThrow(() -> new Exception("Booking not found"));
        return new Booking(bookingEntity.getId(), bookingEntity.getRoomId(), bookingEntity.getCheckinDate(), bookingEntity.getCheckoutDate(),bookingEntity.getFirstName(), bookingEntity.getLastName(), bookingEntity.getEmail());
    }

    @Override
    public List<Booking> getAllBookings() {
        List<BookingEntity> bookingEntities = bookingRepository.findAll();
        List<Booking> bookings = new ArrayList<>();
        for (BookingEntity bookingEntity : bookingEntities) {
            String bookingStatus;
            if (isBookingCancelled(bookingEntity)) {
                bookingStatus = "Cancelled";
            } else {
                bookingStatus = "Booked";
            }
            Booking bookingDto = new Booking(bookingEntity.getId(), bookingEntity.getRoomId(), bookingEntity.getCheckinDate(), bookingEntity.getCheckoutDate(), bookingEntity.getFirstName(), bookingEntity.getLastName(), bookingEntity.getEmail());
            bookingDto.setBookingStatus(bookingStatus);
            bookings.add(bookingDto);
        }

        // Sort the bookings based on the booking status (Booked first, then Cancelled)
        Collections.sort(bookings, (booking1, booking2) -> {
            if (booking1.getBookingStatus().equals("Booked") && booking2.getBookingStatus().equals("Cancelled")) {
                return -1; // booking1 comes before booking2
            } else if (booking1.getBookingStatus().equals("Cancelled") && booking2.getBookingStatus().equals("Booked")) {
                return 1; // booking1 comes after booking2
            } else {
                return 0; // Keep the same order for other cases (both Booked or both Cancelled)
            }
        });

        return bookings;
    }

    private boolean isBookingCancelled(BookingEntity bookingEntity) {
        String bookingStatus = bookingEntity.getBookingStatus();
        if (bookingStatus != null && bookingStatus.equalsIgnoreCase("Cancelled")) {
            return true;
        } else {
            return false;   
            }
    }

    
    @Transactional
    @Modifying
    @Override
    public Booking updateBooking(int id, Booking booking) {
        BookingEntity existingBooking = bookingRepository.findById(id).orElse(null);
        if (existingBooking != null) {
            existingBooking.setFirstName(booking.getFirstName());
            existingBooking.setLastName(booking.getLastName());
            LocalDate checkinDate = booking.getCheckinDate();
            LocalDate checkoutDate = booking.getCheckoutDate();
            if(checkoutDate.isAfter(checkinDate)) {
            	existingBooking.setCheckinDate(booking.getCheckinDate());
                existingBooking.setCheckoutDate(booking.getCheckoutDate());
            }
            else {
                throw new IllegalArgumentException("The checkout date must be after the check-in date.");
            }
            bookingRepository.saveAndFlush(existingBooking);
            return booking;
        }
        return null;
    }

    @Transactional
    @Modifying
    @Override
    public void deleteBooking(int id) {
    	 BookingEntity booking = bookingRepository.getBookingById(id);
    	    if (booking != null) {
    	        booking.setBookingStatus("cancelled"); // Update the status to "cancelled"
    	        bookingRepository.saveAndFlush(booking); // Save the updated booking entity
    	    }        }
    }


