package com.micael.model;

public class Tweet {
    private int id;
    private String tweet;
    private String user_username;

    public Tweet() {
    }

    public Tweet(String tweet, String user_username) {
        this.tweet = tweet;
        this.user_username = user_username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }
}