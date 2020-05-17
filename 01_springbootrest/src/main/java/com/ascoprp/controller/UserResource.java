package com.ascoprp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ascoprp.exceptionhandler.UserNotFoundExcepetion;
import com.ascoprp.model.User;
import com.ascoprp.repository.UserService;

@RestController
public class UserResource {

	@Autowired
	UserService userService;

	// findAll Users
	@GetMapping(path = "/users")
	public List<User> findAll() {
		return userService.findAll();

	}

	// Find a specific User
	@GetMapping(path = "/users/{id}")
	public User findUser(@PathVariable int id) {
		User user = userService.findUser(id);
		if (user == null)
			throw new UserNotFoundExcepetion("User not found with id:" + id);

		return user;
	}

	// save a particular User
	// Return the URI of Created User
	@PostMapping(path = "/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();

	}

	// Delete A User
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userService.findUser(id);
		if (user == null) {
			throw new UserNotFoundExcepetion("User not found with id:" + id);
		}
		userService.deleteUser(id);

	}

}
