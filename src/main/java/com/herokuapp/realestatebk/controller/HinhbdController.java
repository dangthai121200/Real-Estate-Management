package com.herokuapp.realestatebk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.form.FormHinhBd;
import com.herokuapp.realestatebk.service.HinhbdService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class HinhbdController {
	@Autowired
	private HinhbdService hinhbdService;

	@GetMapping(URL.GET_ALL_Hinhbd)
	public List<FormHinhBd> getAllHinhbd() {
		return hinhbdService.getAllHinhbd();
	}
}
