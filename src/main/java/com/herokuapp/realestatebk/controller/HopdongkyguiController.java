package com.herokuapp.realestatebk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.form.FormHopDongKyGui;
import com.herokuapp.realestatebk.service.HopdongkyguiService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class HopdongkyguiController {
	@Autowired
	private HopdongkyguiService hopdongkyguiService;

	@GetMapping(URL.GET_ALL_Hopdongkygui)
	public List<FormHopDongKyGui> getAllHopdongkygui() {
		return hopdongkyguiService.getAllHopdongkygui();
	}
}
