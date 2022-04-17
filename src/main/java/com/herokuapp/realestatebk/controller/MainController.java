package com.herokuapp.realestatebk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.util.URL;

@RestController
public class MainController {

	@RequestMapping(URL.HOME)
	public String main() {
		return "This is backend of real estate manager";
	}

}
