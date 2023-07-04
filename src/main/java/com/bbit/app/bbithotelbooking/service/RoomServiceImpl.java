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
		RoomEntity roomEntity =  roomRepository.getRoomById(roomId);
		return new Room(roomEntity.getId(), roomEntity.getNumber(), roomEntity.getType(), roomEntity.getPrice(), roomEntity.getHotelId());	
	}

	@Override
	public List<Room> getAllRoomsByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomEntity updateRoom(int roomId, Room room) {
		RoomEntity existingRoom = roomRepository.getRoomById(roomId);
		existingRoom.setType(room.getType());
		existingRoom.setPrice(room.getPrice());

		return roomRepository.saveAndFlush(existingRoom);
	}

	@Override
	public void deleteRoom(int roomId) {
		roomRepository.deleteById(roomId);

	}

}
