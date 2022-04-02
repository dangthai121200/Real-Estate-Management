package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Nhanvien;
import com.herokuapp.realestatebk.repository.NhanvienRepository;


@Service
public class NhanvienService {
	
	@Autowired
	private NhanvienRepository nhanvienRepository;

	public List<Nhanvien> getAllNhanvien() {
		return (List<Nhanvien>) nhanvienRepository.findAll();
	}

}
