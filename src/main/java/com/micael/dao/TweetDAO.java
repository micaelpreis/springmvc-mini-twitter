package com.micael.dao;

import java.util.List;

import com.micael.model.Tweet;

public interface TweetDAO {

    void add(Tweet tweet);
    List<Tweet> searchTweets(String search);
    List<Tweet> searchUserTweets(String username, String search);
}