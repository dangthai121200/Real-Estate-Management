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
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.exception.RealEsateException;
import com.herokuapp.realestatebk.form.FormYeucaukhachhang;
import com.herokuapp.realestatebk.service.YeucaukhachhangService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class YeucaukhachhangController {

	@Autowired
	private YeucaukhachhangService yeucaukhachhangService;

	@GetMapping(URL.GET_ALL_Yeucaukhachhang)
	public List<FormYeucaukhachhang> getAllYeucaukhachhang() {
		return yeucaukhachhangService.getAllYeucaukhachhang();
	}

	@PostMapping(URL.ADD_Yeucaukhachhang)
	public FormYeucaukhachhang addYeucaukhachhang(@RequestBody @Valid FormYeucaukhachhang fYeucaukhachhang)
			throws Exception {
		return yeucaukhachhangService.addyeucaukhachhang(fYeucaukhachhang);
	}

	@PutMapping(URL.UPDATE_Yeucaukhachhang)
	public FormYeucaukhachhang editYeucaukhachhang(@RequestBody @Valid FormYeucaukhachhang fYeucaukhachhang)
			throws Exception {
		return yeucaukhachhangService.editYeucaukhachhang(fYeucaukhachhang);
	}

	@DeleteMapping(URL.DELETE_Yeucaukhachhang)
	public FormYeucaukhachhang deleteYeucaukhachhang(@PathVariable int id) throws RealEsateException {
		return yeucaukhachhangService.deleteYeucaukhachhang(id);
	}
}
