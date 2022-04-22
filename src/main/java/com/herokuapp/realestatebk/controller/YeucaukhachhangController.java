package com.herokuapp.realestatebk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.entity.Yeucaukhachhang;
import com.herokuapp.realestatebk.form.FormYeucaukhachhang;
import com.herokuapp.realestatebk.service.YeucaukhachhangService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class YeucaukhachhangController {
	
	@Autowired
	private YeucaukhachhangService yeucaukhachhangService;

	@GetMapping(URL.GET_ALL_Yeucaukhachhang)
	public List<Yeucaukhachhang> getAllYeucaukhachhang() {
		return yeucaukhachhangService.getAllYeucaukhachhang();
	}
	
	@PostMapping(URL.ADD_Yeucaukhachhang)
	public Yeucaukhachhang addyeucaukhachhang(@RequestBody FormYeucaukhachhang fYeucaukhachhang) {
		return yeucaukhachhangService.addyeucaukhachhang(fYeucaukhachhang);
	}
}
