package com.herokuapp.realestatebk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.exception.RealEsateException;
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
	public FormBatdongsan addBatdongsan(@RequestBody @Valid FormBatdongsan fBatdongsan) throws RealEsateException {
		return batdongsanService.addBatdongsan(fBatdongsan);
	}

	@PutMapping(URL.UPDATE_Batdongsan)
	public FormBatdongsan editBatdongsan(@RequestBody @Valid FormBatdongsan fBatdongsan) throws RealEsateException {
		return batdongsanService.editBatdongsan(fBatdongsan);
	}

	@GetMapping(URL.GET_Batdongsan_BY_ID)
	public FormBatdongsan getBatdongsanByID(@PathVariable int id) throws RealEsateException {
		return batdongsanService.getBatdongsanByID(id);
	}

	@DeleteMapping(URL.DELETE_Batdongsan)
	public FormBatdongsan deleteBatdongsan(@PathVariable int id) throws RealEsateException {
		return batdongsanService.deleteBatdongsan(id);
	}

}
