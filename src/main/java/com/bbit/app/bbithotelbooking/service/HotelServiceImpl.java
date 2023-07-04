
package com.bbit.app.bbithotelbooking.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.bbit.app.bbithotelbooking.dto.Hotel;
import com.bbit.app.bbithotelbooking.dto.Room;
import com.bbit.app.bbithotelbooking.entity.HotelEntity;
import com.bbit.app.bbithotelbooking.entity.RoomEntity;
import com.bbit.app.bbithotelbooking.repository.HotelRepository;
import com.bbit.app.bbithotelbooking.repository.RoomRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	RoomRepository roomRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		HotelEntity hotelEntity = new HotelEntity(hotel.getName(), hotel.getAddress(), hotel.getContactNo());
		hotelRepository.saveAndFlush(hotelEntity);
		hotel.setId(hotelEntity.getId());
		return hotel;				
	}

	@Override
	public Hotel getHotelByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<HotelEntity> hotelEntities = hotelRepository.findAll();
		List<Hotel> hotels = new ArrayList<>();
		for (HotelEntity hotelEntity : hotelEntities) {
			Hotel hotelDto = new Hotel(hotelEntity.getId(), hotelEntity.getName(), hotelEntity.getAddress(), hotelEntity.getContactNo());
			hotels.add(hotelDto);
		}
		return hotels;
	}

	@Transactional
	@Modifying
	@Override
	public void updateHotel(int id, Hotel hotel) {
		HotelEntity existingHotel = hotelRepository.getHotelById(id);
		existingHotel.setName(hotel.getName());
		existingHotel.setAddress(hotel.getAddress());

		hotelRepository.saveAndFlush(existingHotel);
	}

	@Transactional
	@Modifying
	@Override
	public void deleteHotel(int id) {
		hotelRepository.deleteById(id);
		
	}

	@Override
	public void searchHotel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hotel getHotelById(int id) throws Exception {
		HotelEntity hotelEntity = hotelRepository.getHotelById(id);
		
		if (hotelEntity != null) {
			List<Room> rooms = new ArrayList<>();
			Hotel hotel = new Hotel(hotelEntity.getId(), hotelEntity.getName(), hotelEntity.getAddress(), hotelEntity.getContactNo());
			List<RoomEntity> roomEntities = roomRepository.getByHotelId(id);
			for(RoomEntity roomEntity : roomEntities) {
				Room room = new Room(roomEntity.getId(), roomEntity.getNumber(), roomEntity.getType(), roomEntity.getPrice(), roomEntity.getHotelId());
				room.setStatus("Available");
				rooms.add(room);
			}
			hotel.setRooms(rooms);
			return hotel;
		} else {
			throw new Exception("Hotel Not Found !!!");
		}
	}

	

}
