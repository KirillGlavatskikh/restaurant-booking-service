package com.example.restaurantbookingservice.service.bookingService;

import com.example.restaurantbookingservice.model.Booking;
import com.example.restaurantbookingservice.repository.bookingDao.BookingDaoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingDaoImpl bookingDaoImpl;

    @Override
    public Booking addNewBooking(Booking booking) {
        return bookingDaoImpl.addNewBooking(booking);
    }

    @Override
    public void deleteBooking(Integer id) {
        bookingDaoImpl.deleteBooking(id);
    }
}
