package com.example.yelpcamp.dao;

import com.example.yelpcamp.entity.Campground;
import com.example.yelpcamp.entity.Comment;

import java.util.List;

public interface CommentDAO {

    List<Comment> getComments();

    List<Comment> getCommentsByCampground(Campground campground);

    void saveComment(Comment comment);

    void updateComment(Comment comment);

    Comment getComment(Long id);

    void deleteComment(Long id);


}
