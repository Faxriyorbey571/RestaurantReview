package uz.kruz.restaurantreview.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.kruz.restaurantreview.domain.CuisineType;
import uz.kruz.restaurantreview.dto.RestaurantDto;
import uz.kruz.restaurantreview.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping
    public List<RestaurantDto> findRestaurants(
            @RequestParam(required = false, defaultValue = "") String searchKeyword,
            @RequestParam(required = false) CuisineType cuisineType,
            @RequestParam(required = false, defaultValue = "0") Integer minRating,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "20") Integer size
    ){
        return restaurantService.findRestaurants(searchKeyword, cuisineType, minRating, page, size);
    }
}
