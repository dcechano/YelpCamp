package com.example.yelpcamp.dao.impl;

import com.example.yelpcamp.dao.CommentDAO;
import com.example.yelpcamp.entity.Campground;
import com.example.yelpcamp.entity.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Comment> getComments() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Comment s").list();
    }

    @Override
    @Transactional
    public List<Comment> getCommentsByCampground(Campground campground) {
        Session session = sessionFactory.getCurrentSession();

        return campground.getComments();
    }

    @Override
    @Transactional
    public void saveComment(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(comment);
    }

    @Override
    @Transactional
    public void updateComment(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.update(comment);

    }

    @Override
    @Transactional
    public Comment getComment(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Comment.class, id);
    }

    @Override
    @Transactional
    public void deleteComment(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Comment where id=:commentId");
        query.setParameter("commentId", id);
        query.executeUpdate();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
