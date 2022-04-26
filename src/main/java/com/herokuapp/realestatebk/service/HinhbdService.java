package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Hinhbd;
import com.herokuapp.realestatebk.form.FormHinhBd;
import com.herokuapp.realestatebk.repository.HinhbdRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class HinhbdService {
	@Autowired
	private HinhbdRepository hinhbdRepository;
	
	public List<FormHinhBd> getAllHinhbd() {
		List<FormHinhBd> formHinhBds = new ArrayList<>();
		List<Hinhbd> hinhbdsList = (List<Hinhbd>) hinhbdRepository.findAll();
		for (Hinhbd hinhbd : hinhbdsList) {
			formHinhBds.add(new FormHinhBd(hinhbd));
		}
		return formHinhBds;
	}
}
