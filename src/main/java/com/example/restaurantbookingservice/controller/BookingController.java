package com.example.restaurantbookingservice.controller;

import com.example.restaurantbookingservice.model.Booking;
import com.example.restaurantbookingservice.service.bookingService.BookingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingServiceImpl bookingServiceImpl;

    @PostMapping("/add-new-booking")
    public Booking addNewBooking(@RequestBody Booking booking) {
        return bookingServiceImpl.addNewBooking(booking);
    }

    @DeleteMapping("/delete-booking/{id}")
    public void deleteBooking(@PathVariable Integer id) {
        bookingServiceImpl.deleteBooking(id);
    }
}
