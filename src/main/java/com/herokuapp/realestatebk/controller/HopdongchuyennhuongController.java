package com.herokuapp.realestatebk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(URL.GET_Hopdongchuyennhuong_BY_ID)
	public FormHopdongchuyennhuong getHopdongchuyennhuongById(@PathVariable("id") int id) {
		return hopdongchuyennhuongService.getHopdongchuyennhuongById(id);
	}

	@PostMapping(URL.ADD_Hopdongchuyennhuong)
	public FormHopdongchuyennhuong addHopdongchuyennhuong(@RequestBody @Valid FormHopdongchuyennhuong formHopdongchuyennhuong, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()) {
			throw new Exception(bindingResult.getAllErrors().get(0).getDefaultMessage());
		} 
		return hopdongchuyennhuongService.addHopdongchuyennhuong(formHopdongchuyennhuong);
	}

	@DeleteMapping(URL.DELETE_Hopdongchuyennhuong)
	public FormHopdongchuyennhuong deleteHopdongchuyennhuong(@PathVariable("id") int cnid) throws Exception {
		return hopdongchuyennhuongService.deleteHopdongchuyennhuong(cnid);
	}
}
