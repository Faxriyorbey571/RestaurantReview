package com.example.restaurantreview.service.impl;

import com.example.restaurantreview.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.restaurantreview.domain.CuisineType;
import com.example.restaurantreview.domain.Restaurant;
import com.example.restaurantreview.dto.RestaurantDto;
import com.example.restaurantreview.repository.RestaurantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDto> findRestaurants(String searchKeyword, CuisineType cuisineType, Integer minRating, Integer page, Integer size) {
        List<Restaurant> restaurants = restaurantRepository.findRestaurants(searchKeyword, cuisineType, minRating, page, size);
        return restaurants.stream().map(restaurant -> RestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .cuisineType(restaurant.getCuisineType())
                .phoneNumber(restaurant.getPhoneNumber())
                .ownerId(restaurant.getOwner().getId())
                .addressId(restaurant.getAddress().getId())
                .rating(restaurant.getRating())
                .build()).toList();
    }
}
