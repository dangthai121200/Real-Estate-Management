package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Hopdongkygui;
import com.herokuapp.realestatebk.repository.HopdongkyguiRepository;

@Service
public class HopdongkyguiService {

	@Autowired
	private HopdongkyguiRepository hopdongkyguiRepository;
	
	public List<Hopdongkygui> getAllHopdongkygui() {
		return (List<Hopdongkygui>) hopdongkyguiRepository.findAll();
	}
}
