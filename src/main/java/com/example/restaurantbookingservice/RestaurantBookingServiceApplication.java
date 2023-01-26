package com.example.restaurantbookingservice;

import com.example.restaurantbookingservice.configuration.SecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.restaurantbookingservice")
public class RestaurantBookingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantBookingServiceApplication.class, args);
    }

}
