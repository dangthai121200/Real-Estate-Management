package com.herokuapp.realestatebk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.entity.Khachhang;
import com.herokuapp.realestatebk.form.FormKhachhang;
import com.herokuapp.realestatebk.service.KhachhangService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class KhachhangController {

	@Autowired
	private KhachhangService khachhangService;

	@GetMapping(URL.GET_ALL_Khachhang)
	public List<Khachhang> getAllKhachhang() {
		return (List<Khachhang>) khachhangService.getAllKhachhang();
	}

	@PostMapping(URL.ADD_Khachhang)
	public Khachhang addKhachhang(@RequestBody FormKhachhang fKhachhang) {
		return (Khachhang) khachhangService.addKhachhang(fKhachhang);
	}

	@PutMapping(URL.UPDATE_Khachhang)
	public Khachhang editKhachhang(@RequestBody FormKhachhang fKhachhang) {
		return (Khachhang) khachhangService.editKhachhang(fKhachhang);
	}

	@DeleteMapping(URL.DELETE_Khachhang)
	public Khachhang deleteKhachhang(@PathVariable int id) throws Exception {
		return khachhangService.deleteNhanvien(id);
	}
}
