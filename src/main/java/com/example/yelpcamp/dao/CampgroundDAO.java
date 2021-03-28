package com.example.yelpcamp.dao;

import com.example.yelpcamp.entity.Campground;

import java.util.List;

public interface CampgroundDAO {

    List<Campground> getCampgrounds();

    void saveCampground(Campground campground);

    Campground getCampgound(Long id);

    void deleteCampground(Long id);

}
