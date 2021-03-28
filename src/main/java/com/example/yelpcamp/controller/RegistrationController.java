package com.example.yelpcamp.controller;

import com.example.yelpcamp.entity.User;
import com.example.yelpcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/registration")
public class RegistrationController extends AbstractController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @GetMapping("/registrationForm")
    public String showRegistrationForm(Model model) {

        model.addAttribute("newUser", new User());

        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processForm(@ModelAttribute("newUser") User user, Model model) {

        String username = user.getUsername();
        logger.info("Processing registration form for: " + username);

        User newUser = userService.findByUsername(username);
        if (newUser != null) {
            model.addAttribute("newUser", new User());
            logger.warning("Username already exists!");
            return "registration-form";
        }

        userService.save(user);
        logger.info("Successfully created user: " + username);

        return "confirmation";
    }
}
