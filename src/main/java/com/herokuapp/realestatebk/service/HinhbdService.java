package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Hinhbd;
import com.herokuapp.realestatebk.repository.HinhbdRepository;

@Service
public class HinhbdService {
	@Autowired
	private HinhbdRepository hinhbdRepository;
	
	public List<Hinhbd> getAllHinhbd() {
		return (List<Hinhbd>) hinhbdRepository.findAll();
	}
}
