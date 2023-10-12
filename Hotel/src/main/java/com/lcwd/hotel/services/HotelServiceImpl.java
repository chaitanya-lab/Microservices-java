package com.lcwd.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.Exceptions.ResourceNotFoundException;
import com.lcwd.hotel.entites.Hotel;
import com.lcwd.hotel.repositories.HotelRepository;


@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
	
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		
		return hotelRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("The hotel you are searching is not available"));

}
}