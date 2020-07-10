package com.example.ratingsystemapplication.dto;

public class UserRatingResponse {

	private String name;

	private String email;

	private String userRole;

	private Float AggRating;

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

}
