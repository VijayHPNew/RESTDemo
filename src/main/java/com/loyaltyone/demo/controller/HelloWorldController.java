package com.loyaltyone.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/displayText")
	public String welcomeMessage() {

		return "Hello World!!!";
	}

	@RequestMapping("/displayText/{strText}")
		public String displayText(@PathVariable String strText) {

			return strText;
	}

	@RequestMapping(method=RequestMethod.POST, value="/displayText/post")
			public String postText(@RequestBody String strText) {

				return strText;
	}


}