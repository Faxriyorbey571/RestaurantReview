package uz.kruz.restaurantreview.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.kruz.restaurantreview.domain.CuisineType;
import uz.kruz.restaurantreview.domain.Restaurant;
import uz.kruz.restaurantreview.dto.RestaurantDto;
import uz.kruz.restaurantreview.repository.RestaurantRepository;

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
                .ownerId(restaurant.getOwnerId())
                .addressId(restaurant.getAddressId())
                .rating(restaurant.getRating())
                .build()).toList();
    }
}
