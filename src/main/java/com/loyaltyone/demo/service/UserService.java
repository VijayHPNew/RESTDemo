package com.loyaltyone.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyaltyone.demo.model.User;
import com.loyaltyone.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {

		//return topics;
		List<User> topics = userRepository.findAll();
		return topics;
	}

	public User getUser(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Optional<User> objOptional = userRepository.findById(id);
		User topic = objOptional.get();
		return topic;

	}

	public User addUser(User user) {
		System.out.println("Inside addUser of UserService- before calling addUser");
		User user1 = userRepository.save(user);
		System.out.println("Inside addUser of UserService- after calling addUser");
		return user1;

	}

	public void updateUser(String id, User user) {

		userRepository.save(user);

	}

	public void deleteUser(String id) {

		userRepository.deleteById(id);

		}



}
