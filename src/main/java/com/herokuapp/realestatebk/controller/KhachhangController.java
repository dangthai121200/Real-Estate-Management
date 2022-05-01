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

import com.herokuapp.realestatebk.exception.RealEsateException;
import com.herokuapp.realestatebk.form.FormKhachhang;
import com.herokuapp.realestatebk.service.KhachhangService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class KhachhangController {

	@Autowired
	private KhachhangService khachhangService;

	@GetMapping(URL.GET_ALL_Khachhang)
	public List<FormKhachhang> getAllKhachhang() {
		return khachhangService.getAllKhachhang();
	}

	@PostMapping(URL.ADD_Khachhang)
	public FormKhachhang addKhachhang(@RequestBody FormKhachhang fKhachhang) {
		return khachhangService.addKhachhang(fKhachhang);
	}

	@PutMapping(URL.UPDATE_Khachhang)
	public FormKhachhang editKhachhang(@RequestBody FormKhachhang fKhachhang) {
		return khachhangService.editKhachhang(fKhachhang);
	}

	@DeleteMapping(URL.DELETE_Khachhang)
	public FormKhachhang deleteKhachhang(@PathVariable int id) throws RealEsateException {
		return khachhangService.deleteKhachHang(id);
	}
	
	@GetMapping(URL.GET_Khachhang_BY_ID)
	public FormKhachhang getKhachhangByID(@PathVariable int id) throws RealEsateException  {
		return khachhangService.getKhachhangByID(id);
	}

}
