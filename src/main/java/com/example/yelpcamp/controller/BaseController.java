package com.example.yelpcamp.controller;

import com.example.yelpcamp.dao.CampgroundDAO;
import com.example.yelpcamp.dao.CommentDAO;
import com.example.yelpcamp.entity.Campground;
import com.example.yelpcamp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@Controller
public class BaseController extends AbstractController{

    Logger log = Logger.getLogger(getClass().getName());

    //    CAMPGROUND MAPPINGS
//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }
//
//    @GetMapping("/campgrounds")
//    public String campgrounds(Model model) {
//        List<Campground> campgrounds = campgroundDAO.getCampgrounds();
//        model.addAttribute("campgrounds", campgrounds);
//        return "campgrounds";
//    }
//
//    @GetMapping("/campgrounds/{id}")
//    public String showCampgrounds(@PathVariable Long id, Model model) {
//        Campground campground = campgroundDAO.getCampgound(id);
//
//        model.addAttribute("campground", campground)
//                .addAttribute("author", campground.getAuthor())
//                .addAttribute("comments", campground.getComments());
//
//        return "show";
//    }

//    @GetMapping("/campgrounds/new")
//    public String newCampground(Model model) {
//        model.addAttribute("newCampground", new Campground());
//        return "newCampground";
//    }
//
//    @PostMapping("/campgrounds/new")
//    public String postNewCampground(@ModelAttribute("newCampground") Campground campground, HttpSession session) {
//        User user = (User) session.getAttribute("user");
//        campground.setAuthor(user);
//        campgroundDAO.saveCampground(campground);
//        return "redirect:/campgrounds/" + campground.getId();
//    }

    @GetMapping("/campgrounds/{campgroundId}/edit")
    public String editCampground(@PathVariable Long campgroundId, Model model, HttpSession session) {

        Campground campground = campgroundDAO.getCampgound(campgroundId);
        User user = (User) session.getAttribute("user");
        if (!user.equals(campground.getAuthor())) {
            return "redirect:/campgrounds/" + campgroundId;
        }

        model.addAttribute("campground", campground);
        return "campgrounds/editCampground";
    }

    @PostMapping("/campgrounds/{campgroundId}/edit")
    public String postEditCampground(@ModelAttribute Campground campground, @PathVariable Long campgroundId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        campground.setAuthor(user);
        campgroundDAO.saveCampground(campground);

        return "redirect:/campgrounds/" + campgroundId;
    }

    // TODO Remove these methods after refactoring @RequestMappings
//    @GetMapping("/campgrounds/{campgroundId}/comments/{commentId}/edit")
//    public String editComment(@PathVariable Long commentId, @PathVariable Long campgroundId, Model model, HttpSession session) {
//
//        User user = (User) session.getAttribute("user");
//        Comment comment = commentDAO.getComment(commentId);
//        if (!user.equals(comment.getAuthor())) {
//            return "redirect:/campgrounds/" + campgroundId;
//        }
//        model.addAttribute("editComment", comment);
//        return "editComment";
//    }

//    @PostMapping("/campgrounds/{campgroundId}/comments/{commentId}/edit")
//    public String editPostComment(@ModelAttribute("editComment") Comment comment,
//                                  @PathVariable Long campgroundId, @PathVariable Long commentId, HttpSession session) {
//
//        User author = (User) session.getAttribute("user");
//        comment.setAuthor(author);
//        Campground campground = campgroundDAO.getCampgound(campgroundId);
//        comment.setCampground(campground);
//
//        commentDAO.saveComment(comment);
//        return "redirect:/campgrounds/" + campgroundId;
//    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }
}
