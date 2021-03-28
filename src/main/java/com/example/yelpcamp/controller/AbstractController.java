package com.example.yelpcamp.controller;

import com.example.yelpcamp.dao.CampgroundDAO;
import com.example.yelpcamp.dao.CommentDAO;
import com.example.yelpcamp.dao.UserDAO;
import com.example.yelpcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


public abstract class AbstractController {
    CampgroundDAO campgroundDAO;
    CommentDAO commentDAO;
    UserDAO userDAO;
    UserService userService;

    @Autowired
    public void setCampgroundDAO(CampgroundDAO campgroundDAO) {
        this.campgroundDAO = campgroundDAO;
    }

    @Autowired
    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
