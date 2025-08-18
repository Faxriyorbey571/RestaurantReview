package com.example.restaurantreview.repository;

import com.example.restaurantreview.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcClient jdbcClient;

    public void createUser(UserDto userDto) {
        jdbcClient.sql("INSERT INTO user(name, email) VALUES (:name, :email)")
                .param("name", userDto.getName())
                .param("email", userDto.getEmail())
                .update();
    }

    public void updateUser(Long id, UserDto userDto) {
        jdbcClient.sql("UPDATE user SET name = :name, email = :email WHERE id = :id")
                .param("name", userDto.getName())
                .param("email", userDto.getEmail())
                .param("id", id)
                .update();
    }

    public void deleteUser(Long id) {
        jdbcClient.sql("DELETE FROM user WHERE id = :id")
                .param("id", id)
                .update();
    }

    public List<UserDto> getAllUsers() {
        return jdbcClient.sql("Select * from user")
                .query(UserDto.class)
                .list();
    }
}
