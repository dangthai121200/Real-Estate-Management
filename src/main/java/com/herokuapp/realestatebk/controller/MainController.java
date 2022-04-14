package com.herokuapp.realestatebk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/")
	public String main() {
		return "This is backend of real estate manager";
	}

}
