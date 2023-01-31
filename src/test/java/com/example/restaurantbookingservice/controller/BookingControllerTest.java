package com.example.restaurantbookingservice.controller;

import com.example.restaurantbookingservice.model.Booking;
import com.example.restaurantbookingservice.model.Establishment;
import com.example.restaurantbookingservice.model.Visitor;
import com.example.restaurantbookingservice.repository.establishmentDao.EstablishmentDao;
import com.example.restaurantbookingservice.repository.visitorDao.VisitorDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("Mike Tyson")
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VisitorDao visitorDao;

    @Autowired
    private EstablishmentDao establishmentDao;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void init(){
        objectMapper = new ObjectMapper();
    }

    @Test
    @Sql(value = "/sql/visitor-for-booking-init.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/sql/booking-for-addnewbooking-destroy.sql",
            "/sql/visitor-for-booking-destroy.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void addNewBooking() throws Exception {

        Visitor visitorName = visitorDao.findByFullName("Petr");
        Establishment establishmentName = establishmentDao.getByName("Кинза");

        Booking booking = new Booking();
        booking.setVisitor(visitorName);
        booking.setEstablishment(establishmentName);
        booking.setTime("20:00");

        String json = objectMapper.writeValueAsString(booking);

        mockMvc.perform(post("/booking/add-new-booking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Sql(value = {"/sql/visitor-for-booking-init.sql",
            "/sql/create-booking-for-delete.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Sql(value = {"/sql/booking-for-delete-destroy.sql",
            "/sql/visitor-for-booking-destroy.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void deleteBooking() throws Exception {
        mockMvc.perform(delete("/booking/delete-booking/333"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}