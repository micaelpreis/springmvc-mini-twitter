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

#### Authentication

* **POST** - /dologin - login to the application
  * parameters:
    * username - login username
    * password - login password
* **POST** - /logout - logout from the application

#### Endpoints

* **POST** - /tweet/create - create a new tweet
  * parameters:
    * tweet - text of the tweet to add
* **GET** - /tweets?search=[query] - search for tweets of all users
* **GET** - /tweets/[username]?search=[query] - search for tweets of specific user
* **GET** - /following - list of users the user follows
* **GET** - /followers - list of users that follow the user
* **POST** - /users/follow - start following a user
  * parameters:
    * username - username of the user to start following
* **POST** - /users/unfollow - start unfollowing a user
  * parameters:
    * username - username of the user to stop following

#### How To Run The Application

1. Create the database 'minitwitter' on MySQL
  * if need be, change the username and password on the file "[spring-database.xml](src/main/webapp/WEB-INF/spring-database.xml)"
2. Run the scripts present on the 'scripts' folder on the following order:
  * create_mini_twitter.sql
  * populate_mini_twitter.sql
  * reset_mini_twitter.sql - Only if you need to delete the data on your database
    * if you run this script, you need to run the two scripts above, after.
3. Import the project to IntelliJ or other IDE.
4. Configure the run configurations of the project
  * on IntelliJ do the following steps:
    1. go to Run > Edit Configurations
    2. click on the '+' on the top left of the window
    3. add Tomcat Server > Local
    4. go to the 'Deployment' tab
    5. click on '+' and choose 'Artifact'
    6. select 'MiniTwitter:war'
    7. Apply the changes
4. Run the project
5. Use the application on your browser or by doing requests to the API
  * to use the endpoints of the application, you first need to successfully login
