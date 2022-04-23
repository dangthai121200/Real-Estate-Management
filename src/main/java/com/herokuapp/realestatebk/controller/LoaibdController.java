package com.herokuapp.realestatebk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.form.FormLoaibd;
import com.herokuapp.realestatebk.service.LoaibdService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class LoaibdController {
	@Autowired
	private LoaibdService loaibdService;

	@GetMapping(URL.GET_ALL_Loaibd)
	public List<FormLoaibd> getAllLoaibd() {
		return loaibdService.getAllLoaibd();
	}
}
