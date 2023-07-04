package com.bbit.app.bbithotelbooking.service;

import java.util.List;

import com.bbit.app.bbithotelbooking.dto.Room;
import com.bbit.app.bbithotelbooking.entity.RoomEntity;

public interface RoomService {

	public Room createRoomInHotel(int hotelId, Room room);

	public Room getRoomById(int roomId) throws Exception;

	public List<Room> getAllRoomsByHotelId(int hotelId);

	public RoomEntity updateRoom(int roomId, Room room);

	public void deleteRoom(int roomId);

}
