package com.example.yelpcamp.dao.impl;

import com.example.yelpcamp.dao.UserDAO;
import com.example.yelpcamp.entity.Campground;
import com.example.yelpcamp.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Override
    public User findByUsername(String username) {

        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("from User where username=:uName", User.class);
        query.setParameter("uName", username);

        User user = null;
        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            // ignore
        }

        return user;
    }

    @Override
    public User findById(Long userId) {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("from User where id=:userId", User.class);
        query.setParameter("userId", userId);

        User user = null;
        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            //            ignore
        }
        return user;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(user);
    }

    @Override
    public List<Campground> getCampgroundsByUser(User user) {
        //        FIXME This is a hack to get the campgrounds from a user. Should be fixed
        Session session = sessionFactory.getCurrentSession();
        User theUser = findById(user.getId());
        Hibernate.initialize(theUser.getCampgrounds());
        return theUser.getCampgrounds();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
