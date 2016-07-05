
-- ADD USERS TO THE DATABASE

INSERT INTO users (username, password, enabled) VALUES ('user1', 'qwerty', 1);
INSERT INTO users (username, password, enabled) VALUES ('user2', 'qwerty', 1);
INSERT INTO users (username, password, enabled) VALUES ('user3', 'qwerty', 1);
INSERT INTO users (username, password, enabled) VALUES ('user4', 'qwerty', 1);
INSERT INTO users (username, password, enabled) VALUES ('user5', 'qwerty', 1);
INSERT INTO users (username, password, enabled) VALUES ('user6', 'qwerty', 1);
INSERT INTO users (username, password, enabled) VALUES ('user7', 'qwerty', 1);
INSERT INTO users (username, password, enabled) VALUES ('user8', 'qwerty', 1);

-- ADD USER ROLES TO THE DATABASE

INSERT INTO user_roles (user_username, role) VALUES ('user1', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('user2', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('user3', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('user4', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('user5', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('user6', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('user7', 'USER');
INSERT INTO user_roles (user_username, role) VALUES ('user8', 'USER');

-- ADD TWEETS TO THE DATABASE

INSERT INTO tweets (user_username, tweet) VALUES ('user1', 'Tweet 1');
INSERT INTO tweets (user_username, tweet) VALUES ('user1', 'Tweet 2');
INSERT INTO tweets (user_username, tweet) VALUES ('user3', 'Tweet 3');

-- ADD FOLLOWERS TO THE DATABASE

INSERT INTO follows (user_followed, follower) VALUES ('user1', 'user2');
INSERT INTO follows (user_followed, follower) VALUES ('user2', 'user1');
INSERT INTO follows (user_followed, follower) VALUES ('user1', 'user3');
