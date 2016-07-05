package com.micael.dao;

import java.util.List;

import com.micael.model.Follow;
import com.micael.model.UserStatus;

public interface FollowDAO {

    int follow(String user);
    int unfollow(String user);
    List<UserStatus> listUsers();
    List<Follow> listFollowing();
    List<Follow> listFollowers();
}