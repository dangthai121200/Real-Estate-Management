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

import com.herokuapp.realestatebk.form.FormBatdongsan;
import com.herokuapp.realestatebk.service.BatdongsanService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class BatdongsanController {

	@Autowired
	private BatdongsanService batdongsanService;

	@RequestMapping(URL.GET_ALL_Batdongsan)
	public List<FormBatdongsan> getAllBatdongsan() {
		return batdongsanService.getAllBatdongsan();
	}

	@PostMapping(URL.ADD_Batdongsan)
	public FormBatdongsan addBatdongsan(@RequestBody FormBatdongsan fBatdongsan) {
		return batdongsanService.addBatdongsan(fBatdongsan);
	}

	@PutMapping(URL.UPDATE_Batdongsan)
	public FormBatdongsan editBatdongsan(@RequestBody FormBatdongsan fBatdongsan) {
		return batdongsanService.editBatdongsan(fBatdongsan);
	}

	@GetMapping(URL.GET_Batdongsan_BY_ID)
	public FormBatdongsan getBatdongsanByID(@PathVariable int id) throws Exception {
		return batdongsanService.getBatdongsanByID(id);
	}
	
	@DeleteMapping(URL.DELETE_Batdongsan)
	public FormBatdongsan deleteBatdongsan(@PathVariable int id) throws Exception {
		return batdongsanService.deleteBatdongsan(id);
	}

}
