# springmvc-mini-twitter
### Spring MVC RESTful API - Mini Twitter

#### Objective

Create the backend for a mini messaging service, inspired by Twitter. It should have a RESTful API with some functionalities.

#### Requirements

1. Spring MVC
2. Spring JDBC Template
3. MySQL
4. Authentication
5. Output in XML or JSON

#### Login

* **POST** - /dologin
  * username
  * password

#### Endpoints

* **POST** - /tweet/create - create a new tweet
  * tweet
* **GET** - /tweets?search=[query] - search for tweets of all users
* **GET** - /tweets/[username]?search=[query] - search for tweets of specific user
* **GET** - /following - list of users the user follows
* **GET** - /followers - list of users that follow the user
* **POST** - /users/follow - start following a user
  * username
* **POST** - /users/unfollow - start unfollowing a user
  * username

#### How To Run The Application

1. Create the database 'minitwitter' on MySQL
  * If need be, change the username and password on the file "/src/main/webapp/WEB-INF/script-database.xml"
  * If need be, change the username and password on the file "[script-database.xml](src/main/webapp/WEB-INF/script-database.xml)"
2. Run the scripts present on the 'scripts' folder on the following order:
  * create_mini_twitter.sql
  * populate_mini_twitter.sql
  * reset_mini_twitter.sql - Only if you need to delete the data on your database
    * If you run this script, you need to run the two scripts above, after.
3. Import the project to IntelliJ or other IDE.
4. Run the project on Tomcat 8.
