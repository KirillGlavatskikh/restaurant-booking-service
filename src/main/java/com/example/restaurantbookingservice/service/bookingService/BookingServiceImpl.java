package com.example.restaurantbookingservice.service.bookingService;

import com.example.restaurantbookingservice.model.Booking;
import com.example.restaurantbookingservice.repository.bookingDao.BookingDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingDao bookingDao;

    @Override
    public Booking addNewBooking(Booking booking) {
        return bookingDao.addNewBooking(booking);
    }

    @Override
    public void deleteBooking(Integer id) {
        bookingDao.deleteBooking(id);
    }
}
