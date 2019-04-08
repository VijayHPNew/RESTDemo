package com.loyaltyone.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loyaltyone.demo.model.User;
import com.loyaltyone.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.GET, value="/users")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}

	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable String id) {
		return userService.getUser(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/users", produces="application/json", consumes="application/json")
	public User addUser(@RequestBody User user) {
		System.out.println("Inside addUser - before calling addUser. User first name: "+user.getStrFirstName());
		User user1 = userService.addUser(user);
		System.out.println("Inside addUser - after calling addUser. User first name: "+user1.getStrFirstName());
		return user1;

	}

	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public void updateTopic(@RequestBody User user, @PathVariable String id) {

		userService.updateUser(id, user);

	}

	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public void deleteTopic(@PathVariable String id) {

		userService.deleteUser(id);
	}
}
