package com.example.restaurantreview.dto;

import lombok.Builder;
import uz.kruz.restaurantreview.domain.CuisineType;

@Builder
public class RestaurantDto {
    private Long id;
    private String name;
    private CuisineType cuisineType;
    private String phoneNumber;
    private Long ownerId;
    private Long addressId;
    private Double rating;
}
