package com.example.ratingsystemapplication.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ratingsystemapplication.dto.Response;
import com.example.ratingsystemapplication.dto.RideRateInfoDto;
import com.example.ratingsystemapplication.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	RatingService ratingService;

	@RequestMapping(value = "/getRating", method = RequestMethod.GET)
	public Response getRating(@NotNull @RequestBody String email) {
		return ratingService.getRating(email);
	}

	@RequestMapping(value = "/giveRating", method = RequestMethod.POST)
	public Response giveRating(@NotNull @RequestBody RideRateInfoDto rideRateInfoDto) {
		return ratingService.giveRating(rideRateInfoDto);
	}
}
