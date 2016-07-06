package com.micael.controller;

import com.micael.dao.TweetDAO;
import com.micael.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TweetController {

    @Autowired
    private TweetDAO tweetDAO;

    // NEW TWEET PAGE
    @RequestMapping(value = "/tweet/new", method = RequestMethod.GET)
    public ModelAndView newTweet(ModelAndView model) {
        Tweet newTweet = new Tweet();
        model.addObject("tweet", newTweet);
        model.setViewName("tweets/newTweetPage");
        return model;
    }

    // NEW TWEET
    @RequestMapping(value = "/tweet/create", method = RequestMethod.POST, produces = {"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity createTweet(@ModelAttribute("tweetForm") Tweet tweet) {
        int result = tweetDAO.add(tweet);
        if (result == 1) {
            return ResponseEntity.ok("{\"message\": \"Success!\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error!\"}");
        }
    }

    // GET ALL TWEETS
    @RequestMapping(value = "/tweets/formatted", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView tweets(ModelAndView model, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<Tweet> listTweets = tweetDAO.searchTweets(search);
        model.addObject("listTweets", listTweets);
        model.addObject("search", search);
        model.setViewName("tweets/tweetsPage");
        return model;
    }

    // GET TWEETS OF A USER
    @RequestMapping(value = "/tweets/{username}/formatted", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView tweetsUser(ModelAndView model, @PathVariable String username, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<Tweet> listTweets = tweetDAO.searchUserTweets(username, search);
        model.addObject("listTweets", listTweets);
        model.addObject("username", username);
        model.addObject("search", search);
        model.setViewName("tweets/tweetsPage");
        return model;
    }

    // GET ALL TWEETS AS XML OR JSON
    @RequestMapping(value = "/tweets", method = RequestMethod.GET, produces = {"application/json","application/xml"})
    @ResponseBody
    public List<Tweet> tweets_XML_JSON(@RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<Tweet> listTweets = tweetDAO.searchTweets(search);
        return listTweets;
    }

    // GET TWEETS OF A USER AS JSON AND XML
    @RequestMapping(value = "/tweets/{username}", method = RequestMethod.GET, produces = {"application/json","application/xml"})
    @ResponseBody
    public List<Tweet> tweetsUser_XML_JSON(@PathVariable String username, @RequestParam(value = "search", defaultValue = "", required=false) String search) {
        List<Tweet> listTweets = tweetDAO.searchUserTweets(username, search);
        return listTweets;
    }
}