package com.bbit.app.bbithotelbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbit.app.bbithotelbooking.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer>{

	public List<RoomEntity> getByHotelId(Integer hotelId);

	public void deleteById(Integer roomId);
	
}
