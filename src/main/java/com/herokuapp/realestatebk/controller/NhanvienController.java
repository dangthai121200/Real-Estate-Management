package com.herokuapp.realestatebk.controller;

import java.net.BindException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.form.FormLogin;
import com.herokuapp.realestatebk.form.FormNhanvien;
import com.herokuapp.realestatebk.service.NhanvienService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class NhanvienController {

	@Autowired
	private NhanvienService nhanvienService;

	@GetMapping(URL.GET_ALL_Nhanvien)
	public List<FormNhanvien> getAllNhanvien() {
		return nhanvienService.getAllNhanvien();
	}

	@PostMapping(URL.ADD_Nhanvien)
	public FormNhanvien addNhanvien(@RequestBody @Valid FormNhanvien fNhanvien) throws Exception {
		
		return nhanvienService.addNhanvien(fNhanvien);
	}

	@PutMapping(URL.UPDATE_Nhanvien)
	public FormNhanvien editNhanvien(@RequestBody @Valid FormNhanvien fNhanvien, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			throw new Exception(bindingResult.getAllErrors().get(0).getDefaultMessage());
		} 
		return nhanvienService.editNhanvien(fNhanvien);
	}

	@DeleteMapping(URL.DELETE_Nhanvien)
	public FormNhanvien deleteNhanvien(@PathVariable int id) throws Exception {
		return nhanvienService.deleteNhanvien(id);
	}

	@PostMapping(URL.LOGIN_Nhanvien)
	public FormNhanvien loginNhanvien(@RequestBody FormLogin formLogin) {
		return nhanvienService.login(formLogin);
	}
}
