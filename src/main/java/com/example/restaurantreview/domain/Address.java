package com.example.restaurantreview.domain;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "unit")
    private String unit;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;
}

