package com.example.restaurantbookingservice.controller;

import com.example.restaurantbookingservice.model.Visitor;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("Павел Алексеев")
@Sql(value = "/sql/visitor-init-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/sql/visitor-destroy-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class VisitorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void init(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/visitor/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addNewUser() throws Exception {
        Visitor visitor = new Visitor();
        visitor.setId(10);
        visitor.setPassword("9999");
        visitor.setFullName("user");
        visitor.setIsActive(true);

        String json = objectMapper.writeValueAsString(visitor);

        mockMvc.perform(post("/visitor/add-user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.fullName").value("user"))
                .andExpect(jsonPath("$.isActive").value(true));

    }

    @Test
    void addNewAdmin() throws Exception {
        Visitor visitor = new Visitor();
        visitor.setId(11);
        visitor.setPassword("0000");
        visitor.setFullName("admin");
        visitor.setIsActive(true);

        String json = objectMapper.writeValueAsString(visitor);

        mockMvc.perform(post("/visitor/add-admin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(11))
                .andExpect(jsonPath("$.fullName").value("admin"))
                .andExpect(jsonPath("$.isActive").value(true));

    }

    @Test
    void deleteVisitor() throws Exception {

        mockMvc.perform(delete("/visitor/delete/123"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}