package com.example.restaurantbookingservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "visitor_name")
    private Visitor visitor;
    @ManyToOne
    @JoinColumn(name = "establishment_name")
    private Establishment establishment;
    @Column(name = "booking_time")
    private LocalTime time;
}
