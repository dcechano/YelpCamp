package com.example.yelpcamp.controller;

import com.example.yelpcamp.dao.CampgroundDAO;
import com.example.yelpcamp.dao.CommentDAO;
import com.example.yelpcamp.entity.Campground;
import com.example.yelpcamp.entity.User;
import com.example.yelpcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class ProfileController extends AbstractController{

    @GetMapping("/{userId}")
    public String showProfile(@PathVariable Long userId, Model model) {
        User user = userDAO.findById(userId);
        List<Campground> campgrounds = userDAO.getCampgroundsByUser(user);

        model.addAttribute("user", user)
                .addAttribute("campgrounds", campgrounds);

        return "profile/profile";
    }
}
