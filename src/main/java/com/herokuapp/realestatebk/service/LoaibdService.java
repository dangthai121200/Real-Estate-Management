package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Loaibd;
import com.herokuapp.realestatebk.repository.LoaibdRepository;

@Service
public class LoaibdService {
	
	@Autowired
	private LoaibdRepository loaibdRepository;
	
	public List<Loaibd> getAllLoaibd() {
		return (List<Loaibd>) loaibdRepository.findAll();
	}
}
