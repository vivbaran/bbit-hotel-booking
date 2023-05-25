package com.bbit.app.bbithotelbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bbit.app.bbithotelbooking.dto.Hotel;
import com.bbit.app.bbithotelbooking.dto.Room;
import com.bbit.app.bbithotelbooking.service.HotelService;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/hotels")
    public String addHotel(@RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
        return "Hotel Added Successfully -" + hotel.getHotelName();
    }

    @GetMapping("/hotels/{hotelName}")
    public ResponseEntity<Hotel> getHotelByName(@PathVariable("hotelName") String hotelName) {
        Hotel hotels = hotelService.getHotelByName(hotelName);
        if (hotels != null) {
            return ResponseEntity.ok(hotels);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/hotels/{hotelName}")
    public ResponseEntity<String> updateHotelDetails(@PathVariable("hotelName") String hotelName, @RequestBody Hotel hotel) {
        Hotel existingHotel = hotelService.getHotelByName(hotelName);
        if(existingHotel != null) {
        	existingHotel.setHotelName(hotel.getHotelName());
        	existingHotel.setAddress(hotel.getAddress());
        	existingHotel.setCity(hotel.getCity());
        	existingHotel.setCountry(hotel.getCountry());
        	
        	hotelService.updateHotelDetails(existingHotel);
        	
        	return ResponseEntity.ok("Hotel Updated Successfully\n"
        	        + "Hotel Name: " + hotel.getHotelName() + "\n"
        	        + "Address: " + hotel.getAddress() + "\n"
        	        + "City: " + hotel.getCity() + "\n"
        	        + "Country: " + hotel.getCountry());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/hotels/{hotelName}")
    public ResponseEntity<String> deleteHotelByName(@PathVariable("hotelName") String hotelName) {
        hotelService.deleteHotelByName(hotelName);
	     return ResponseEntity.ok("Hotel Deleted Successfully");
    }
    
    @GetMapping("/hotels/search")
    public ResponseEntity<List<Hotel>> searchHotel(@RequestParam("city") String city) {
        List<Hotel> hotel = hotelService.searchHotel(city);
        if (!hotel.isEmpty()) {
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/hotels/{hotelName}/rooms")
    public ResponseEntity<String> addRoomToHotel(@PathVariable("hotelName") String hotelName, @RequestBody Room room) {
        Hotel hotel = hotelService.getHotelByName(hotelName);
        if (hotel != null) {
            room.setHotelName(hotelName);
            hotelService.addRoom(room);
            return ResponseEntity.ok("Room added to hotel: " + hotelName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @GetMapping("/hotels/{hotelName}/rooms")
    public ResponseEntity<List<Room>> getRoomsByHotelName(@PathVariable("hotelName") String hotelName) {
        List<Room> rooms = hotelService.getRoomsByHotelName(hotelName);
        if (!rooms.isEmpty()) {
            return ResponseEntity.ok(rooms);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/hotels/{hotelName}/rooms")
    public ResponseEntity<String> updateRoomsByHotelName(@PathVariable("hotelName") String hotelName, @RequestBody Room room) {
        List<Room> existingRooms = hotelService.getRoomsByHotelName(hotelName);
        
        if (existingRooms != null && !existingRooms.isEmpty()) {
            for (Room existingRoom : existingRooms) {
                existingRoom.setRoomNumber(room.getRoomNumber());
                existingRoom.setRoomType(room.getRoomType());
                existingRoom.setRoomPrice(room.getRoomPrice());
                
                hotelService.updateRoom(existingRoom);
            }
            
            return ResponseEntity.ok("Room Updated Successfully -\nHotel Name: " +  hotelName + "\n"
                        + "Room Number: " + room.getRoomNumber() + "\n"
                        + "Room Type: " + room.getRoomType() + "\n");
        } else {
            return ResponseEntity.notFound().build();
        }
             
    }
    
    @DeleteMapping("/hotels/{hotelName}/rooms/{roomNumber}")
    public ResponseEntity<String> deleteRoomsByHotelNameAndRoomNumber(@PathVariable("hotelName") String hotelName, @PathVariable("roomNumber") int roomNumber) {
        hotelService.deleteRoomsByHotelNameAndRoomNumber(hotelName, roomNumber);
            return ResponseEntity.ok("Successfully Deleted Room from Hotel: " + hotelName + "And For Room Number" + roomNumber);
        }
}

