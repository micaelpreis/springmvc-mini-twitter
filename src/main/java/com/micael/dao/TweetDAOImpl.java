package com.micael.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.micael.model.Tweet;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class TweetDAOImpl implements TweetDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(Tweet tweet) {
        String username = getUsername();
        String sql = "INSERT INTO tweets (tweet, user_username)" + " VALUES (?, ?)";

        jdbcTemplate.update(sql, tweet.getTweet(), username);
    }

    @Override
    public List<Tweet> searchTweets(String search) {
        String sql = "SELECT * FROM tweets WHERE tweet LIKE '%" + search + "%' ORDER BY tweet_id DESC";
        List<Tweet> listTweets = jdbcTemplate.query(sql, new RowMapper<Tweet>() {

            @Override
            public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tweet tweet = new Tweet();

            tweet.setId(rs.getInt("tweet_id"));
            tweet.setTweet(rs.getString("tweet"));
            tweet.setUser_username(rs.getString("user_username"));

            return tweet;
            }
        });

        return listTweets;
    }

    @Override
    public List<Tweet> searchUserTweets(String username, String search) {
        String sql = "SELECT * FROM tweets WHERE user_username = '"+ username+"' AND tweet LIKE '%" + search + "%' ORDER BY tweet_id DESC";
        List<Tweet> listTweets = jdbcTemplate.query(sql, new RowMapper<Tweet>() {

            @Override
            public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tweet tweet = new Tweet();

            tweet.setId(rs.getInt("tweet_id"));
            tweet.setTweet(rs.getString("tweet"));
            tweet.setUser_username(rs.getString("user_username"));

            return tweet;
            }
        });

        return listTweets;
    }

    public String getUsername() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
}