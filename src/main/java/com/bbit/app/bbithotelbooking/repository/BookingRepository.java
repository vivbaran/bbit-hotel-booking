package com.bbit.app.bbithotelbooking.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bbit.app.bbithotelbooking.dto.Booking;
import com.bbit.app.bbithotelbooking.util.Queries;

@Repository
public class BookingRepository {
	
	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void createBooking(Booking booking) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("bookingId", booking.getBookingId());
        parameterSource.addValue("hotelName", booking.getHotelName());
        parameterSource.addValue("email", booking.getEmail());
        parameterSource.addValue("checkinDate", booking.getCheckinDate());
        parameterSource.addValue("checkoutDate", booking.getCheckoutDate());
        
        namedParameterJdbcTemplate.update(Queries.INSERT_BOOKINGS, parameterSource);
	}
	
	
	public Booking getBookingByEmail(String email) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("email", email);
		
	    return namedParameterJdbcTemplate.queryForObject(Queries.GET_BOOKING_BY_EMAIL, parameterSource, new BeanPropertyRowMapper<>(Booking.class));
	}
	
	
	public void updateBookingDetails( Booking booking) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("hotelName", booking.getHotelName());
        parameterSource.addValue("email", booking.getEmail());
		parameterSource.addValue("checkinDate", booking.getCheckinDate());
		parameterSource.addValue("checkoutDate", booking.getCheckoutDate());
		
        namedParameterJdbcTemplate.update(Queries.UPDATE_BOOKING_DETAILS, parameterSource);

	}

	
	public void deleteBooking(String email) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("email", email);
		
		namedParameterJdbcTemplate.update(Queries.DELETE_BOOKING, mapSqlParameterSource);
	}
}
