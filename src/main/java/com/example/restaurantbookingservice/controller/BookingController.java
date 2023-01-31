package com.example.restaurantbookingservice.controller;

import com.example.restaurantbookingservice.model.Booking;
import com.example.restaurantbookingservice.service.bookingService.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/add-new-booking")
    public Booking addNewBooking(@RequestBody Booking booking) {
        return bookingService.addNewBooking(booking);
    }

    @DeleteMapping("/delete-booking/{id}")
    public void deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
    }
}
