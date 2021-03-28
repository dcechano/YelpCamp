package com.example.yelpcamp.dao;

import com.example.yelpcamp.entity.Role;

public interface RoleDAO {
    Role findRoleByName(String role);
}
