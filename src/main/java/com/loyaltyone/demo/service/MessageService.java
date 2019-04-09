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

		//return topics;
		List<Message> listMessage = messageRepository.findAll();
		return listMessage;
	}

	public Message getMessage(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Optional<Message> objOptional = messageRepository.findById(id);
		Message message = objOptional.get();
		return message;

	}

	public List<Message> addMessage(Message message) {
		//System.out.println("Inside addMessage of MessageService- before calling addMessage");
		messageRepository.save(message);
		//System.out.println("Inside addMessage of MessageService- after calling addMessage");
		List<Message> listOfMessages = messageRepository.findAllByUserName(message.getUserName());
		return listOfMessages;

	}

	public void updateMessage(String id, Message message) {

		messageRepository.save(message);

	}

	public void deleteUser(String id) {

		messageRepository.deleteById(id);

		}



}
