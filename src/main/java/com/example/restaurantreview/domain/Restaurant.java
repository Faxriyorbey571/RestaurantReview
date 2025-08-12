package com.example.restaurantreview.domain;

import lombok.Data;

@Data
public class Restaurant {
    private Long id;
    private String name;
    private CuisineType cuisineType;
    private String phoneNumber;
    private Long ownerId;
    private Long addressId;
    private Double rating;
}
