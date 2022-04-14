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

import com.herokuapp.realestatebk.entity.Nhanvien;
import com.herokuapp.realestatebk.form.FormLogin;
import com.herokuapp.realestatebk.form.FormNhanvien;
import com.herokuapp.realestatebk.service.NhanvienService;

@RestController
@RequestMapping("/nhanvien")
public class NhanvienController {

	@Autowired
	private NhanvienService nhanvienService;

	@GetMapping
	public List<Nhanvien> getAllNhanvien() {
		List<Nhanvien> nhanvienList = nhanvienService.getAllNhanvien();
		return nhanvienList;
	}

	@PostMapping
	public Nhanvien addNhanvien(@RequestBody FormNhanvien fNhanvien) {
		Nhanvien nhanvienAdd = nhanvienService.addNhanvien(fNhanvien);
		return nhanvienAdd;
	}

	@PutMapping
	public Nhanvien editNhanvien(@RequestBody FormNhanvien fNhanvien) {
		Nhanvien nhanvienEdit = nhanvienService.editNhanvien(fNhanvien);
		return nhanvienEdit;
	}

	@DeleteMapping("/{id}")
	public Nhanvien deleteNhanvien(@PathVariable int id) throws Exception {
		return nhanvienService.deleteNhanvien(id);
	}

	@PostMapping("/login")
	public Nhanvien loginNhanvien(@RequestBody FormLogin formLogin) {
		Nhanvien nhanvien = nhanvienService.login(formLogin);
		return nhanvien;
	}

}
