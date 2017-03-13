package org.pk.controller;

import java.util.Collection;

import org.pk.dto.UserCreateRequest;
import org.pk.model.User;
import org.pk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable long id) {
		return userService.getUserById(id).orElseThrow(RuntimeException::new);
	}
	
	@RequestMapping("/users")
	public Collection<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/users")
	public long createUser(@RequestBody UserCreateRequest request) {
		return userService.create(request).getId();
	}
}