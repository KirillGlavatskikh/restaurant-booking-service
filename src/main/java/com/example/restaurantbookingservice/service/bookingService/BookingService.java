package com.example.restaurantbookingservice.service.bookingService;

import com.example.restaurantbookingservice.model.Booking;

public interface BookingService {

    Booking addNewBooking(Booking booking);

    void deleteBooking(Integer id);
}
