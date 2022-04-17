package com.herokuapp.realestatebk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.service.BatdongsanService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class BatdongsanController {

	@Autowired
	private BatdongsanService batdongsanService;

	@RequestMapping(URL.GET_ALL_Batdongsan)
	public List<Batdongsan> getAllBatdongsan() {
		return batdongsanService.getAllBatdongsan();
	}

}
