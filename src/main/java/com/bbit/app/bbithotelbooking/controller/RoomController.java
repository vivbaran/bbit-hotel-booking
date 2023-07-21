package com.bbit.app.bbithotelbooking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bbit.app.bbithotelbooking.dto.Hotel;
import com.bbit.app.bbithotelbooking.dto.Room;
import com.bbit.app.bbithotelbooking.entity.RoomEntity;
import com.bbit.app.bbithotelbooking.service.HotelService;
import com.bbit.app.bbithotelbooking.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	HotelService hotelService;
	
	@Autowired
	RoomService roomService;
	
	@GetMapping("/user/hotel/addRoom/new/{id}")
	public String createHotelRoomForm(@PathVariable int id,Model model) {

		Room room = new Room();
		room.setHotelId(id);
		model.addAttribute("room", room);
		return "create_room";
	}
	
	@PostMapping("/user/hotel/addRoom/{hotelId}")
	public String createHotelRoom(@PathVariable int hotelId, @ModelAttribute Room room, Model model) throws Exception {
		
		roomService.createRoomInHotel(hotelId, room);

		return getHotelDetails(hotelId, model);
	}
	
	@GetMapping("/user/updateRoom/{id}")
	public String editRoomForm(@PathVariable int id, Model model) throws Exception {
		model.addAttribute("room", roomService.getRoomById(id));
		return "edit_room";
	}

	@PostMapping("/updateRoom/{id}")
	public String updateHotel(@PathVariable int id, @ModelAttribute("room") Room room, Model model)
			throws Exception {

		RoomEntity roomEntity = roomService.updateRoom(id, room);
		return getHotelDetails(roomEntity.getHotelId(), model);
	}
	
	@GetMapping("/deleteRoom/{id}")
	public String deleteRoom(@PathVariable int id, Model model)
			throws Exception {

		Room deletedRoom = roomService.getRoomById(id);
		roomService.deleteRoom(id);
		return getHotelDetails(deletedRoom.getHotelId(), model);
	}

	
	private String getHotelDetails(int hotelId, Model model) throws Exception {
		List<Hotel> hotels = new ArrayList<>();
		hotels.add(hotelService.getHotelById(hotelId));
		model.addAttribute("hotelDetails", hotels);
		return "hotelDetails";
	}
}
