package com.rossprojects.workoutlog.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rossprojects.workoutlog.entity.User;
import com.rossprojects.workoutlog.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	// autowire the CustomerService
	@Autowired
	private UserService userService;
	
	// add mapping for GET /customers
	@GetMapping("/users")
	public List<User> getUsers() {
		
		return userService.getUsers();
	}
	
	// add mapping for GET /customers/{customerId}
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {
		
		User theUser = userService.getUser(userId);
		
		if (theUser == null) {
			throw new UserNotFoundException("User id not found - " + userId);
		}
			
		return theUser;
	}
	
	// add mapping for POST /customers - add new customer
	
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theUser.setId(0);
		
		userService.saveUser(theUser);
		
		return theUser;
	}
	
	// add mapping for PUT /customers - update existing customer
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User theUser) {
		
		userService.saveUser(theUser);
		
		return theUser;
	}
	
	// add mapping for DELETE /users/{userId} - delete user
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		
		User tempUser = userService.getUser(userId);
		
		// throw exception if null
		
		if (tempUser == null) {
			throw new UserNotFoundException("User id not found - " + userId);
		}
		
		userService.deleteUser(userId);
		
		return "Deleted customer id - " + userId;
		
	}
	
	
	
}
