package com.herokuapp.realestatebk.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.boot.jaxb.spi.Binding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public FormKhachhang addKhachhang(@RequestBody @Valid FormKhachhang fKhachhang,BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			throw new Exception(bindingResult.getAllErrors().get(0).getDefaultMessage());
		} 
		return khachhangService.addKhachhang(fKhachhang);
	}

	@PutMapping(URL.UPDATE_Khachhang)
	public FormKhachhang editKhachhang(@RequestBody @Valid FormKhachhang fKhachhang,BindingResult bindingResult)throws Exception {
		if(bindingResult.hasErrors()) {
			throw new Exception(bindingResult.getAllErrors().get(0).getDefaultMessage());
		} 
		return khachhangService.editKhachhang(fKhachhang);
	}

	@DeleteMapping(URL.DELETE_Khachhang)
	public FormKhachhang deleteKhachhang(@PathVariable int id) throws Exception {
		return khachhangService.deleteKhachHang(id);
	}
	
	@GetMapping(URL.GET_Khachhang_BY_ID)
	public FormKhachhang getKhachhangByID(@PathVariable int id) throws Exception  {
		return khachhangService.getKhachhangByID(id);
	}

}
