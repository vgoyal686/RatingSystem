package com.example.ratingsystemapplication.entity;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userRating")
public class UserRating extends Asset {

	private String name;

	@NotNull
	@Indexed(unique = true)
	private String email;

	/* ("driver" or "rider") */
	private String userRole;

	@Column(precision = 3, scale = 2)
	private Float AggRating;

	private int totalUserRated;

	private int sumOfMaxRatingUserCount;

	@Column(precision = 3, scale = 2)
	private int sumOfRatings;
	
	public UserRating() {

	}

	public UserRating(String name, String email, String userRole) {
		super();
		this.name = name;
		this.email = email;
		this.userRole = userRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Float getAggRating() {
		return AggRating;
	}

	public void setAggRating(Float aggRating) {
		AggRating = aggRating;
	}

	public int getTotalUserRated() {
		return totalUserRated;
	}

	public void setTotalUserRated(int totalUserRated) {
		this.totalUserRated = totalUserRated;
	}

	public int getSumOfMaxRatingUserCount() {
		return sumOfMaxRatingUserCount;
	}

	public void setSumOfMaxRatingUserCount(int sumOfMaxRatingUserCount) {
		this.sumOfMaxRatingUserCount = sumOfMaxRatingUserCount;
	}

	public int getSumOfRatings() {
		return sumOfRatings;
	}

	public void setSumOfRatings(int sumOfRatings) {
		this.sumOfRatings = sumOfRatings;
	}

}
