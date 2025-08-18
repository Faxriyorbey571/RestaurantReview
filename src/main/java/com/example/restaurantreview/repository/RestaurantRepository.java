package com.example.restaurantreview.repository;

import com.example.restaurantreview.domain.CuisineType;
import com.example.restaurantreview.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findRestaurants(String searchKeyword, CuisineType cuisineType, Integer minRating, Integer page, Integer size);

}