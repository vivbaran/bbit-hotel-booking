
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
import com.bbit.app.bbithotelbooking.service.HotelService;
import com.bbit.app.bbithotelbooking.service.RoomService;

@Controller
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@Autowired
	RoomService roomService;
	
	@GetMapping("/user/hotel/new")
	public String createHotelForm(Model model) {

		Hotel hotel = new Hotel();
		model.addAttribute("hotel", hotel);
		return "create_hotel";
	}
	
	@PostMapping("/user/hotel/addHotel")
	public String createHotel(@ModelAttribute Hotel hotel) {
		
		hotelService.createHotel(hotel);


		return "redirect:/user/hotels";
	}

	@GetMapping("/user/hotels")
	public String getAllHotels(Model model) {
		List<Hotel> hotels = hotelService.getAllHotels();
		model.addAttribute("hotels", hotels);
		return "hotels";
	}

	@GetMapping("/user/updateHotel/{id}")
	public String editHotelForm(@PathVariable int id, Model model) throws Exception {
		model.addAttribute("hotel", hotelService.getHotelById(id));
		return "edit_hotel";
	}

	@PostMapping("/updateHotel/{id}")
	public String updateHotel(@PathVariable int id, @ModelAttribute("hotel") Hotel hotel, Model model)
			throws Exception {

		hotelService.updateHotel(id, hotel);
		return "redirect:/user/hotels";
	}
	
	@GetMapping("/user/viewHotel/{id}")
	public String viewHotel(@PathVariable int id, Model model)
			throws Exception {

		List<Hotel> hotels = new ArrayList<>();
		hotels.add(hotelService.getHotelById(id));
		model.addAttribute("hotelDetails", hotels);
		return "hotelDetails";
	}
	
	@GetMapping("/deleteHotel/{id}")
	public String deleteHotel(@PathVariable int id)
			throws Exception {

		hotelService.deleteHotel(id);
		return "redirect:/user/hotels";
	}
	
	@GetMapping("/user/hotel/addRoom/new")
	public String createHotelRoomForm(Model model) {

		Room room = new Room();
		model.addAttribute("room", room);
		return "create_room";
	}
	
	@PostMapping("/user/hotel/addRoom/{id}")
	public String createHotelRoom(@PathVariable int hotelId, @ModelAttribute Room room) {
		
		roomService.createRoomInHotel(hotelId, room);


		return "redirect:/user/hotelDetails";
	}

}
