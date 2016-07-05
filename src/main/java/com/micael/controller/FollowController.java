package com.micael.controller;

import com.micael.dao.FollowDAO;
import com.micael.model.Follow;
import com.micael.model.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FollowController {

    @Autowired
    private FollowDAO followDAO;

    // FOLLOW USER
    @RequestMapping(value = "/users/follow", method = RequestMethod.POST, produces = {"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity followUser(@ModelAttribute("followForm") UserStatus user) {
        int result = followDAO.follow(user.getUsername());
        if (result == 1) {
            return ResponseEntity.ok("{\"message\": \"Success!\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error!\"}");
        }
    }


    // UNFOLLOW USER
    @RequestMapping(value = "/users/unfollow", method = RequestMethod.POST, produces = {"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity unfollowUser(@ModelAttribute("unfollowForm") UserStatus user) {
        int result = followDAO.unfollow(user.getUsername());
        if (result == 1) {
            return ResponseEntity.ok("{\"message\": \"Success!\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error!\"}");
        }
    }

    // FOLLOW PAGE
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView followPage(ModelAndView model) {
        UserStatus followForm = new UserStatus();
        UserStatus unfollowForm = new UserStatus();
        model.addObject("followForm", followForm);
        model.addObject("unfollowForm", unfollowForm);

        List<UserStatus> listUsers = followDAO.listUsers();
        model.addObject("listUsers", listUsers);

        model.setViewName("follows/followPage");
        return model;
    }

    // FOLLOWING PAGE
    @RequestMapping(value = "/following/formatted", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView following(ModelAndView model) {
        List<Follow> listFollowing = followDAO.listFollowing();
        model.addObject("listFollowing", listFollowing);
        model.setViewName("follows/followingPage");
        return model;
    }

    // FOLLOWERS PAGE
    @RequestMapping(value = "/followers/formatted", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView followers(ModelAndView model) {
        List<Follow> listFollowers = followDAO.listFollowers();
        model.addObject("listFollowers", listFollowers);
        model.setViewName("follows/followersPage");
        return model;
    }

    // FOLLOWING PAGE AS XML OR JSON
    @RequestMapping(value = "/following", method = RequestMethod.GET, produces = {"application/json","application/xml"})
    @ResponseBody
    public List<Follow> following_XML_JSON() {
        List<Follow> listFollowing = followDAO.listFollowing();
        return listFollowing;
    }

    // FOLLOWERS PAGE AS XML OR JSON
    @RequestMapping(value = "/followers", method = RequestMethod.GET, produces = {"application/json","application/xml"})
    @ResponseBody
    public List<Follow> followers_XML_JSON() {
        List<Follow> listFollowers = followDAO.listFollowers();
        return listFollowers;
    }
}