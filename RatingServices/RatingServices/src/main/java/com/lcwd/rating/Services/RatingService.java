package com.lcwd.rating.Services;

import java.util.List;

import com.lcwd.rating.entities.Rating;

public interface RatingService {
	
	//Create
	
	Rating Create(Rating rating);
	
	
	//get all rating.
	List<Rating> getRating();
	
	
	//get all by UserID
	List<Rating> getRatingByUserId(String userId);
	
	
	//get all by HotelID
	List<Rating> getRatingByHotelId(String hotelId);
	
	

}
