package com.example.restaurantbookingservice.repository.bookingDao;

import com.example.restaurantbookingservice.model.Booking;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class BookingDaoImpl implements BookingDao {

    private final String DELETE_BOOKING_PATH = "DELETE FROM Booking b WHERE b.id = :id";

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

        Query query = entityManager.createQuery(DELETE_BOOKING_PATH);
        query.setParameter("id", id);
//        Booking booking = entityManager.find(Booking.class, id);
//        entityManager.remove(booking);
//        entityManager.flush();
    }
}
