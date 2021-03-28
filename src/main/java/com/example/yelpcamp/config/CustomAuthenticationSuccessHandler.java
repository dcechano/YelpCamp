package com.example.yelpcamp.config;

import com.example.yelpcamp.entity.User;
import com.example.yelpcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();

        User user = userService.findByUsername(username);

        HttpSession session = request.getSession();

        session.setAttribute("user", user);

        response.sendRedirect(request.getContextPath() + "/campgrounds");

    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
