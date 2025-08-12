package uz.kruz.restaurantreview.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import uz.kruz.restaurantreview.domain.CuisineType;
import uz.kruz.restaurantreview.domain.Restaurant;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RestaurantRepository {
    private final JdbcClient jdbcClient;

    public List<Restaurant> findRestaurants(String searchKeyword, CuisineType cuisineType, Integer minRating, Integer page, Integer size) {
        StringBuilder sql = new StringBuilder("select * from restaurant where name like concat('%',:searchKeyword,'%') and rating>=:minRating");
        if (cuisineType != null) {
            sql.append(" ").append("and cuisine_type=:cuisineType");
        }
        sql.append(" ").append("limit :size offset :offset");
        int offset = (page - 1) * size;
        return jdbcClient.sql(sql.toString())
                .param("searchKeyword", searchKeyword)
                .param("cuisineType", cuisineType)
                .param("minRating", minRating)
                .param("offset", offset)
                .param("size", size)
                .query(Restaurant.class)
                .list();
    }
}
