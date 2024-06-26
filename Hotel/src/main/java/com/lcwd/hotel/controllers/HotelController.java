package com.lcwd.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.entites.Hotel;
import com.lcwd.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;

	@PostMapping("/addHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));

	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getHotel(){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.getAll());
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){

		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.get(hotelId));
	}
	
}
