package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.repository.BatdongsanRepository;


@Service
public class BatdongsanService {
	
	@Autowired
	private BatdongsanRepository batdongsanReponsitory;
	
	public List<Batdongsan> getAllBatdongsan(){
		
		return (List<Batdongsan>) batdongsanReponsitory.findAll();
	}
}
