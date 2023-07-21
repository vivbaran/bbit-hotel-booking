package com.bbit.app.bbithotelbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bbit.app.bbithotelbooking.entity.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

	//public List<BookingEntity> getAllBookings();
	
	public void deleteById(Integer id);
	
	public BookingEntity getBookingById(Integer id);
}
