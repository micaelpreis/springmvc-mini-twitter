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

* **GET** - /tweets?search=[query] - search for tweets of all users
* **GET** - /tweets/[username]?search=[query] - search for tweets of specific user
* **GET** - /following - list of users the user follows
* **GET** - /followers - list of users that follow the user
* **POST** - /users/follow - start following a user
  * username
* **POST** - /users/unfollow - start unfollowing a user
  * username
