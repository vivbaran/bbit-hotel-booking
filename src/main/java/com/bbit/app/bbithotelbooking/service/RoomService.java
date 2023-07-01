package com.bbit.app.bbithotelbooking.service;

import java.util.List;

import com.bbit.app.bbithotelbooking.dto.Room;

public interface RoomService {

	public Room createRoomInHotel(int hotelId, Room room);

	public Room getRoomById(int roomId) throws Exception;

	public List<Room> getAllRoomsByHotelId(int hotelId);

	public void updateRoom(int roomId);

	public void deleteRoom(int roomId);

}
