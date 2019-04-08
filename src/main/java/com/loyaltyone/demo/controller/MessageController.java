package com.loyaltyone.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loyaltyone.demo.model.Message;
import com.loyaltyone.demo.service.MessageService;


@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@RequestMapping("/messages")
	public String welcomeMessage() {

		return "Hello World!!!";
	}

	@RequestMapping("/messages/{strText}")
		public String displayText(@PathVariable String strText) {

			return strText;
	}

	@RequestMapping(method=RequestMethod.POST, value="/messages", produces="application/json", consumes="application/json")
			public Message postMessage(@RequestBody Message message) {
			Message message1 = messageService.addMessage(message);
			return message1;
	}


}