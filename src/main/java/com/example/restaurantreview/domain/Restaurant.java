package com.example.restaurantreview.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Enumerated(value = EnumType.STRING)
    private CuisineType cuisineType;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User owner;
    @OneToOne
    private Address address;
    private Double rating;
}
