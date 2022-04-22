package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Hopdongchuyennhuong;
import com.herokuapp.realestatebk.repository.HopdongchuyennhhuongRepository;

@Service
public class HopdongchuyennhuongService {

	@Autowired
	private HopdongchuyennhhuongRepository hopdongchuyennhhuongRepository;
	
	public List<Hopdongchuyennhuong> getAllHopdongchuyennhuong() {
		return (List<Hopdongchuyennhuong>) hopdongchuyennhhuongRepository.findAll();
	}
}