package com.bbit.app.bbithotelbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbit.app.bbithotelbooking.dto.Room;
import com.bbit.app.bbithotelbooking.entity.RoomEntity;
import com.bbit.app.bbithotelbooking.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomRepository roomRepository;

	@Override
	public Room createRoomInHotel(int hotelId, Room room) {
		RoomEntity roomEntity = new RoomEntity(hotelId, room.getNumber(), room.getType(), room.getPrice());
		roomEntity = roomRepository.saveAndFlush(roomEntity);
		room.setId(roomEntity.getId());
		return room;
	}

	@Override
	public Room getRoomById(int roomId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> getAllRoomsByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRoom(int roomId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRoom(int roomId) {
		// TODO Auto-generated method stub

	}

}
