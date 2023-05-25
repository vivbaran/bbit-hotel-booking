package com.bbit.app.bbithotelbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbit.app.bbithotelbooking.dto.Hotel;
import com.bbit.app.bbithotelbooking.dto.Room;
import com.bbit.app.bbithotelbooking.repository.HotelRepository;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public void addHotel(Hotel hotel) {
        hotelRepository.addHotel(hotel);
    }
    
    public Hotel getHotelByName(String hotelName) {
        return hotelRepository.getHotelByName(hotelName);
    }
    
    public void updateHotelDetails(Hotel hotel) {
        hotelRepository.updateHotelDetails(hotel);
    }
    
    public void deleteHotelByName(String hotelName) {
	    hotelRepository.deleteHotelByName(hotelName);
	}
    
    public List<Hotel> searchHotel(String city) {
        return hotelRepository.searchHotel(city);
    }
    
    public void addRoom(Room room) {
        hotelRepository.addRoom(room);
    }

    
    public List<Room> getRoomsByHotelName(String hotelName) {
        return hotelRepository.getRoomsByHotelName(hotelName);
    }
    
    public void updateRoom(Room room) {
        hotelRepository.updateRoom(room);
    }
    
    public void deleteRoomsByHotelNameAndRoomNumber(String hotelName, int roomNumber) {
        hotelRepository.deleteRoomsByHotelNameAndRoomNumber(hotelName, roomNumber);
    }

}
