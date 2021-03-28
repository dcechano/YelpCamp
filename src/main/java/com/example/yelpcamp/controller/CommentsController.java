package com.example.yelpcamp.controller;

import com.example.yelpcamp.dao.CampgroundDAO;
import com.example.yelpcamp.dao.CommentDAO;
import com.example.yelpcamp.entity.Campground;
import com.example.yelpcamp.entity.Comment;
import com.example.yelpcamp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@Controller
@RequestMapping("/comments")
public class CommentsController extends AbstractController{

    Logger log = Logger.getLogger(getClass().getName());

    //    Create New Comment
    @GetMapping("/new")
    public String newComment(Model model, @RequestParam Long campgroundId) {
        model.addAttribute("newComment", new Comment())
                .addAttribute("campgroundId", campgroundId);

        return "comments/newComment";
    }

    @PostMapping("/new")
    public String postNewComment(@ModelAttribute("newComment") Comment comment, @RequestParam Long campgroundId, HttpSession session) {

        Campground campground = campgroundDAO.getCampgound(campgroundId);
        User user = (User) session.getAttribute("user");
        comment.setCampground(campground);
        comment.setAuthor(user);
        commentDAO.saveComment(comment);

        return "redirect:/campgrounds/show?campgroundId=" + campgroundId;
    }

    //    EDIT COMMENT
    @GetMapping("/edit")
    public String editComment(@RequestParam Long campgroundId, @RequestParam Long commentId, Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");
        Comment comment = commentDAO.getComment(commentId);
        if (!user.equals(comment.getAuthor())) {
            return "redirect:/campgrounds/" + campgroundId;
        }
        model.addAttribute("editComment", comment)
                .addAttribute("campgroundId", campgroundId);

        return "comments/editComment";
    }

    @PostMapping("/edit")
    public String editPostComment(@ModelAttribute("editComment") Comment comment,
                                  @RequestParam Long campgroundId, HttpSession session) {

//        User author = (User) session.getAttribute("user");
//        comment.setAuthor(author);
//        Campground campground = campgroundDAO.getCampgound(campgroundId);
//        comment.setCampground(campground);
        commentDAO.saveComment(comment);
        return "redirect:/campgrounds/show?campgroundId=" + campgroundId;
    }

//    DELETE MAPPINGS
    @GetMapping("/delete")
    public String deleteComment(@RequestParam Long commentId, Model model) {
        model.addAttribute("commentId", commentId);
        return "comments/deleteAlert";
    }

    @GetMapping("/delete/confirmed")
    public String deleteCommentConfirmed(@RequestParam Long commentId) {
        commentDAO.deleteComment(commentId);
        return "redirect:/campgrounds/";
    }
}