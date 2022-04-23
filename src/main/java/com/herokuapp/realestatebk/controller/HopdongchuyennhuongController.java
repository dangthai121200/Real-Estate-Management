package com.herokuapp.realestatebk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.form.FormHopdongchuyennhuong;
import com.herokuapp.realestatebk.service.HopdongchuyennhuongService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class HopdongchuyennhuongController {
	@Autowired
	private HopdongchuyennhuongService hopdongchuyennhuongService;

	@GetMapping(URL.GET_ALL_Hopdongchuyennhuong)
	public List<FormHopdongchuyennhuong> getAllHopdongchuyennhuong() {
		return hopdongchuyennhuongService.getAllHopdongchuyennhuong();
	}
}
