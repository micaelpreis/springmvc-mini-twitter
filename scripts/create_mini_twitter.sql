
-- TABLE USERS

CREATE TABLE users
(
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL, 
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY(username)
);

-- TABLE USER ROLES (ADMIN / USER) 

CREATE TABLE user_roles
(
  user_role_id INT(11) NOT NULL AUTO_INCREMENT,
  user_username VARCHAR(45) NOT NULL,
  role VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_role_id)
);

-- TABLE TWEET 

CREATE TABLE tweets
(
  tweet_id INT(11) NOT NULL AUTO_INCREMENT,
  tweet VARCHAR(140) NOT NULL,
  user_username VARCHAR(45) NOT NULL,
  PRIMARY KEY (tweet_id)
);

-- TABLE FOLLOWERS

CREATE TABLE follows
(
	user_followed VARCHAR(45) NOT NULL,
	follower VARCHAR(45) NOT NULL,
	PRIMARY KEY(user_followed,follower)
);

-- CONSTRAINTS

ALTER TABLE user_roles ADD CONSTRAINT user_role_uk UNIQUE (user_username, role);
ALTER TABLE tweets ADD CONSTRAINT tweets_fk1 FOREIGN KEY (user_username) REFERENCES users(username);
ALTER TABLE follows ADD CONSTRAINT follows_fk1 FOREIGN KEY (user_followed) REFERENCES users(username);
ALTER TABLE follows ADD CONSTRAINT follows_fk2 FOREIGN KEY (follower) REFERENCES users(username);
