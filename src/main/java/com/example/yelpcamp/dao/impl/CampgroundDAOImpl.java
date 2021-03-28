package com.example.yelpcamp.dao.impl;

import com.example.yelpcamp.dao.CampgroundDAO;
import com.example.yelpcamp.entity.Campground;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CampgroundDAOImpl implements CampgroundDAO {

    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Campground> getCampgrounds() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Campground s").list();
    }

    @Override
    @Transactional
    public void saveCampground(Campground campground) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(campground);
    }

    @Override
    @Transactional
    public Campground getCampgound(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Campground campground = session.get(Campground.class, id);
        Hibernate.initialize(campground.getComments());
        return campground;
    }

    @Override
    @Transactional
    public void deleteCampground(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Campground where id=:campgroundId");
        query.setParameter("campgroundId", id);
        query.executeUpdate();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
