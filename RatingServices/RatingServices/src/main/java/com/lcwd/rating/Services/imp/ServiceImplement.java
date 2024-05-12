package com.lcwd.rating.Services.imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.Services.RatingService;
import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repository.ratingRepo;

@Service
public class ServiceImplement implements RatingService {
	
	
	@Autowired
	private ratingRepo repository;

	@Override
	public Rating Create(Rating rating) {
		String randomRatingId=UUID.randomUUID().toString();
	    rating.setRatingId(randomRatingId);
		return repository.save(rating);
	}

	@Override
	public List<Rating> getRating() {
	
		return repository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {

		return repository.findByHotelId(hotelId);
	}
	
	

}
