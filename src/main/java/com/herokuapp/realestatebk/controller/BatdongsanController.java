package com.herokuapp.realestatebk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.entity.Khachhang;
import com.herokuapp.realestatebk.form.FormBatdongsan;
import com.herokuapp.realestatebk.form.FormKhachhang;
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
	
	@PostMapping(URL.ADD_Batdongsan)
	public Batdongsan addBatdongsan(@RequestBody FormBatdongsan fBatdongsan) {
		return batdongsanService.addBatdongsan(fBatdongsan);
	}

	@PutMapping(URL.UPDATE_Batdongsan)
	public Batdongsan editBatdongsan(@RequestBody FormBatdongsan fBatdongsan) {
		return batdongsanService.editBatdongsan(fBatdongsan);
	}

	@GetMapping(URL.GET_Batdongsan_BY_ID)
	public Batdongsan getBatdongsanByID(@PathVariable int id){
		return null;
	}

}
