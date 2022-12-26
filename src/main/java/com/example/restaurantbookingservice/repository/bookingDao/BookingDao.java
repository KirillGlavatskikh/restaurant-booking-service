package com.example.restaurantbookingservice.repository.bookingDao;

import com.example.restaurantbookingservice.model.Booking;

public interface BookingDao {

    Booking addNewBooking(Booking booking);

    void deleteBooking(Integer id);
}
