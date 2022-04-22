package com.herokuapp.realestatebk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.entity.Hopdongdatcoc;
import com.herokuapp.realestatebk.service.HopdongdatcocService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class HopdongdatcocController {
	@Autowired 
	private HopdongdatcocService hopdongdatcocService;
	
	@GetMapping(URL.GET_ALL_Hopdongdatcoc)
	public List<Hopdongdatcoc> getAllHopdongdatcoc() {
		return hopdongdatcocService.getAllHopdongdatcoc();
	}
}
