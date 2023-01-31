package com.example.restaurantbookingservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "visitor_name",
            referencedColumnName = "full_name")
    private Visitor visitor;
    @OneToOne
    @JoinColumn(name = "establishment_name",
            referencedColumnName = "establishment_name")
    private Establishment establishment;
    @Column(name = "booking_time")
    private String time;
}
