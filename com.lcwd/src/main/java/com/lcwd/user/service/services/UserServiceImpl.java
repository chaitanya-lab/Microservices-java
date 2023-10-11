package com.lcwd.user.service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.Exceptions.ResourceNotFoundException;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
	
		String randomUserId=UUID.randomUUID().toString();
	    user.setUserId(randomUserId);
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {

		return this.userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
	
		return userRepository.findById(userId).orElseThrow(()-> 
		new ResourceNotFoundException("The user you are searching is not available"));
	}

}
