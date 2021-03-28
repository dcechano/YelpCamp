package com.example.yelpcamp.dao.impl;

import com.example.yelpcamp.dao.RoleDAO;
import com.example.yelpcamp.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private SessionFactory sessionFactory;

    @Override
    public Role findRoleByName(String roleName) {

        Session session = sessionFactory.getCurrentSession();

        Query<Role> query = session.createQuery("from Role where name=:roleName", Role.class);
        query.setParameter("roleName", roleName);

        Role role = null;

        try {
            role = query.getSingleResult();
        } catch (Exception e) {
            // ignore
        }

        return role;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
