package com.loyaltyone.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.loyaltyone.demo.model.Message;
import com.loyaltyone.demo.service.MessageService;


@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	/*
	 * This method is to display a hard-coded message to the user. This is implemented as a REST service using
	 * GET method
	 */
	@RequestMapping("/messages")
	public String welcomeMessage() {

		return "Hello World!!!";
	}
	
	/*
	 * This method is to display the message passed in the URL. This is implemented as a REST service using
	 * GET method. This accepts a String parameter which will be returned as response for display
	 */
	@RequestMapping("/messages/{strText}")
		public String displayText(@PathVariable String strText) {

			return strText;
	}
	
	/*
	 * This method is to POST the message entered in a form. This is implemented as a REST service using
	 * POST method. After storing in Database, this method returns the new object created and pass
	 * this as reponse object
	 */
	@RequestMapping(method=RequestMethod.POST, value="/messages", produces="application/json", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
			public List<Message> postMessage(@RequestBody Message message) {
			List<Message> listOfMessages = messageService.addMessage(message);
			
			return listOfMessages;
	}


}