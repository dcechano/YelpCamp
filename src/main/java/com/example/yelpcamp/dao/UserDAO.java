package com.example.yelpcamp.dao;

import com.example.yelpcamp.entity.Campground;
import com.example.yelpcamp.entity.User;

import java.util.List;

public interface UserDAO {

    User findByUsername(String username);

    void save(User user);

    User findById(Long userId);

    List<Campground> getCampgroundsByUser(User user);


}
