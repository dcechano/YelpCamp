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
import java.util.List;

@Controller
@RequestMapping("/campgrounds")
public class CampgroundController extends AbstractController {

    @GetMapping
    public String campgrounds(Model model) {
        List<Campground> campgrounds = campgroundDAO.getCampgrounds();
        model.addAttribute("campgrounds", campgrounds);
        return "campgrounds/campgrounds";
    }

    @GetMapping("/show")
    public String showCampground(@RequestParam Long campgroundId, Model model) {
        Campground campground = campgroundDAO.getCampgound(campgroundId);
        model.addAttribute("campground", campground);
        model.addAttribute("comments", campground.getComments());
        return "campgrounds/show";
    }

    @GetMapping("/new")
    public String newCampground(Model model) {
        model.addAttribute("newCampground", new Campground());
        return "campgrounds/newCampground";
    }

    @PostMapping("/new")
    public String postNewCampground(@ModelAttribute("newCampground") Campground campground, HttpSession session) {
        User user = (User) session.getAttribute("user");
        campground.setAuthor(user);
        campgroundDAO.saveCampground(campground);
        return "redirect:/campgrounds/show?campgroundId=" + campground.getId();
    }

    //   EDIT MAPPINGS

    @GetMapping("/edit")
    public String editCampground(@RequestParam Long campgroundId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Campground campground = campgroundDAO.getCampgound(campgroundId);
        if (!campground.getAuthor().getId().equals(user.getId())) {
            return "redirect:/campgrounds/show?campgroundId=" + campgroundId;
        }
        model.addAttribute("campground", campground);
        return "campgrounds/editCampground";
    }

    //    DELETE MAPPINGS
    @GetMapping("/delete")
    public String deleteCampground(@RequestParam Long campgroundId, Model model) {
        model.addAttribute("campgroundId", campgroundId);
        return "campgrounds/deleteAlert";
    }

    @GetMapping("/delete/confirmed")
    public String deleteCampgroundConfirmed(@RequestParam Long campgroundId, HttpSession session) {
        campgroundDAO.deleteCampground(campgroundId);
        return "redirect:/campgrounds";
    }
}
