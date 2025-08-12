package com.example.restaurantreview.service;

import com.example.restaurantreview.domain.CuisineType;
import com.example.restaurantreview.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    List<RestaurantDto> findRestaurants(String searchKeyword,
                                        CuisineType cuisineType,
                                        Integer minRating,
                                        Integer page,
                                        Integer size);
}
