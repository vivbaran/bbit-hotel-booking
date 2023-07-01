package com.bbit.app.bbithotelbooking.service;

import java.util.List;

import com.bbit.app.bbithotelbooking.dto.Hotel;

public interface HotelService {
	
	public Hotel createHotel(Hotel user);
	
	public Hotel getHotelByName(String name);
	
	public Hotel getHotelById(int id) throws Exception;
	
	public List<Hotel> getAllHotels();

	public void updateHotel(int id, Hotel user);
	
	public void deleteHotel(int id);
	
	public void searchHotel();

}
