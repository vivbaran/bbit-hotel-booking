package com.bbit.app.bbithotelbooking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bbit.app.bbithotelbooking.dto.Booking;
import com.bbit.app.bbithotelbooking.service.BookingService;
import com.bbit.app.bbithotelbooking.service.RoomService;
@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;
    
    @Autowired
    RoomService roomService;

    @GetMapping("/user/bookRoom/{id}")
    public String createBookingForm(@PathVariable int id, Model model) {
        Booking booking = new Booking();
        booking.setRoomId(id);
        model.addAttribute("booking", booking);
        return "create_booking";
    }

    @PostMapping("/user/bookRoom/createBooking/{roomId}")
    public String createBooking(@PathVariable int roomId, @ModelAttribute Booking booking, Model model) {
        bookingService.createBooking(roomId, booking);
        return "redirect:/user/bookings";
    }
    
    @GetMapping("/user/bookings")
    public String getAllBookings(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "bookings";
    }
    
    @GetMapping("/user/updateBooking/{id}")
    public String editBookingForm(@PathVariable int id, Model model) throws Exception {
        model.addAttribute("booking", bookingService.getBookingById(id));
        return "edit_booking";
    }

    @PostMapping("/updateBooking/{id}")
    public String updateBooking(@PathVariable int id, @ModelAttribute("booking") Booking booking) throws Exception {
        bookingService.updateBooking(id, booking);
        return "redirect:/user/bookings";
    }

    @GetMapping("/cancelBooking/{id}")
    public String deleteBooking(@PathVariable int id) throws Exception {
        bookingService.deleteBooking(id);
        return "redirect:/user/bookings";
    }
}
