package com.herokuapp.realestatebk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.exception.RealEsateException;
import com.herokuapp.realestatebk.form.Formhopdongdatcoc;
import com.herokuapp.realestatebk.service.HopdongdatcocService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class HopdongdatcocController {
	@Autowired
	private HopdongdatcocService hopdongdatcocService;

	@GetMapping(URL.GET_ALL_Hopdongdatcoc)
	public List<Formhopdongdatcoc> getAllHopdongdatcoc() {
		return hopdongdatcocService.getAllHopdongdatcoc();
	}
	
	@GetMapping(URL.GET_Hopdongdatcoc_BY_ID)
	public Formhopdongdatcoc getHopdongdatcocById(@PathVariable("id") int id) {
		return hopdongdatcocService.getHopdongdatcocById(id);
	}
	
	@PostMapping(URL.ADD_Hopdongdatcoc)
	public Formhopdongdatcoc addHopdongdatcoc(@RequestBody Formhopdongdatcoc formhopdongdatcoc) throws RealEsateException {
		return hopdongdatcocService.addHopdongdatcoc(formhopdongdatcoc);
	}
	
	@DeleteMapping(URL.DELETE_Hopdongdatcoc)
	public Formhopdongdatcoc deleteHopdongdatcoc(@PathVariable("id") int id) throws RealEsateException {
		return hopdongdatcocService.deleteHopdongdatcoc(id);
	}
}
