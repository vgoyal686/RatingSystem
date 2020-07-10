# RatingSystem

### Tech Stack:
  - Java 1.8
  - Mongo Db v4.2.5
  - Spring Boot v2.3.1

### Info:
  - There are two API's, one for get the rating and other for give the rating.
  - There are two main entities in this system which extends one basic Asset which includes id, createdAt, updatedAt, createdBy, updatedBy, one is UserRating which includes some basic info of user, total user rated, userrole(driver or rider), max rating, sum of ratings, agg rating. Other is RideRatingInfo which includes ride id, driver email, rider email, ratingByRider and ratingByDriver.

### DB:
  - MongoDB is used
  - Two Main Entities: UserRating, RideRatingInfo.
  - NO scripts needed to run because i used commandLiner it will fill up sample data in the database.

### Steps to run:
  - install and setup jdk 1.8
  - install mongodb v4.2 or higher
  - maven clean build and run
