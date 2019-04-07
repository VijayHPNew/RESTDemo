package com.loyaltyone.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/helloworld")
	public String welcomeMessage() {

		return "Hello World!!!";
	}

}