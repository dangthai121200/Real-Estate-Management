package com.herokuapp.realestatebk.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.entity.Nhanvien;
import com.herokuapp.realestatebk.service.NhanvienService;

@RestController
@RequestMapping("/nhanvien")
public class NhanvienController {

	@Autowired
	private NhanvienService nhanvienService;
	
	
	@GetMapping
	public List<Nhanvien>getAllNhanvien(){
		List<Nhanvien> nhanvienList = nhanvienService.getAllNhanvien();
		return nhanvienList;
	}
	
	@PostMapping
	public Nhanvien addNhanvien(@RequestBody Nhanvien nhanvien){
		Nhanvien nhanvienAdd = nhanvienService.addNhanvien(nhanvien);
		return nhanvienAdd;
	}
	
	@PutMapping
	public Nhanvien editNhanvien(@RequestBody Nhanvien nhanvien){
		Nhanvien nhanvienEdit = nhanvienService.editNhanvien(nhanvien);
		return nhanvienEdit;
	}
	
	@DeleteMapping("/{id}")
	public void deleteNhanvien(@PathVariable int id){
		nhanvienService.deleteNhanvien(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Nhanvien> loginNhanvien(@RequestParam("email") String email, @RequestParam("pass") String pass){
		Nhanvien checkedNhanvien = nhanvienService.checkExistNhanvien(email, pass);
		if(checkedNhanvien==null)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Nhanvien>(checkedNhanvien, HttpStatus.OK);
	}
	
	
}
