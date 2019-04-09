package com.loyaltyone.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loyaltyone.demo.model.Message;
import com.loyaltyone.demo.model.User;
import com.loyaltyone.demo.repository.MessageRepository;
import com.loyaltyone.demo.repository.UserRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public List<Message> getAllMessages() {

		List<Message> listMessage = messageRepository.findAll();
		return listMessage;
	}

	public Message getMessage(String id) {
		
		Optional<Message> objOptional = messageRepository.findById(id);
		Message message = objOptional.get();
		return message;

	}

	public List<Message> addMessage(Message message) {
		messageRepository.save(message);
		List<Message> listOfMessages = messageRepository.findAllByUserName(message.getUserName());
		return listOfMessages;

	}
	
	/*
	 * The below methods are NOT implemented at the moment. But typically this will be used to
	 * complete the possibility of adding all real-time CRUD operations like update and delete.
	 */
	public void updateMessage(String id, Message message) {

		messageRepository.save(message);

	}

	public void deleteUser(String id) {

		messageRepository.deleteById(id);

	}



}
