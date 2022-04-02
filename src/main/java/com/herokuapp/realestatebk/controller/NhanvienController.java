package com.herokuapp.realestatebk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.entity.Nhanvien;
import com.herokuapp.realestatebk.service.NhanvienService;

@RestController
public class NhanvienController {

	@Autowired
	private NhanvienService nhanvienService;
	
	
	@GetMapping("/nhanvien")
	public List<Nhanvien>getAllNhanvien(){
		List<Nhanvien> nhanvienList = nhanvienService.getAllNhanvien();
		return nhanvienList;
	}
	
	
	
	
}
