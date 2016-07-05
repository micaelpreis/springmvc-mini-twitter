package com.micael.model;

public class Follow {
    private String user_followed;
    private String follower;

    public Follow() {
    }

    public Follow(String user_followed, String follower) {
        this.user_followed = user_followed;
        this.follower = follower;
    }

    public String getUser_followed() {
        return user_followed;
    }

    public void setUser_followed(String user_followed) {
        this.user_followed = user_followed;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }
}