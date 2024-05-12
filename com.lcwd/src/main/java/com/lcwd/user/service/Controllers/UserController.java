package com.lcwd.user.service.Controllers;

import java.util.List;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){

		User user1=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);

	}

	@GetMapping
	public ResponseEntity<List<User>> getUserDetail() {
		List<User> user=userService.getAllUser();
		return ResponseEntity.ok(user);

	}
	@GetMapping("/{userId}")
	@CircuitBreaker(name="myCircuitBreaker", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUserById(@PathVariable String userId){
	User user1=	userService.getUser(userId);
		return ResponseEntity.ok(user1); 
	}
	
	//Creating fallback method for  circuitbreaker
	
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
		
		
		logger.info("fallback is excuted because server is down"+ex.getMessage());
		
		 User user = User.builder()
		            .userId("12387")
		            .name("John Doe")
		            .email("john@example.com")
		            .about("This is created because server is down")
		            .build();
		 return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}

}
