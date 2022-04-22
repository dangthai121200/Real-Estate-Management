package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Loaibd;
import com.herokuapp.realestatebk.entity.Yeucaukhachhang;
import com.herokuapp.realestatebk.repository.YeucaukhachhangRepository;

@Service
public class YeucaukhachhangService {
	
	@Autowired
	private YeucaukhachhangRepository yeucaukhachhangRepository;
	
	public List<Yeucaukhachhang> getAllYeucaukhachhang() {
		return (List<Yeucaukhachhang>) yeucaukhachhangRepository.findAll();
	}

}
