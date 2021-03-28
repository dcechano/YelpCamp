package com.example.yelpcamp.service;

import com.example.yelpcamp.entity.Campground;
import com.example.yelpcamp.entity.User;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    void save(User user);

    User findById(Long userId);

    List<Campground> getCampgroundsByUser(User user);
}
