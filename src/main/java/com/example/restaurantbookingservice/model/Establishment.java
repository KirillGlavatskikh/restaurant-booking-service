package com.example.restaurantbookingservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "establishment_name ")
    private String establishmentName;
    @ManyToOne
    @JoinColumn(name = "format")
    private EstablishmentFormat establishmentFormat;
    @Column(name = "everage_check")
    private Integer everageCheck;
}
