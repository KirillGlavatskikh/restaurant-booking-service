package com.example.restaurantbookingservice.repository.bookingDao;

import com.example.restaurantbookingservice.model.Booking;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookingDaoImpl implements BookingDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Booking addNewBooking(Booking booking) {
        entityManager.persist(booking);
        entityManager.flush();
        return booking;
    }

    @Override
    @Transactional
    public void deleteBooking(Integer id) {
        Booking booking = entityManager.find(Booking.class, id);
        entityManager.remove(booking);
        entityManager.flush();
    }
}
