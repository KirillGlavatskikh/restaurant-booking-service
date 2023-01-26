package com.example.restaurantbookingservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "establishment")
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "establishment_name ")
    private String establishmentName;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "format",
            referencedColumnName = "format_name")
    private EstablishmentFormat establishmentFormat;
    @Column(name = "everage_check")
    private Integer everageCheck;
}
