package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Loaibd;
import com.herokuapp.realestatebk.form.FormLoaibd;
import com.herokuapp.realestatebk.repository.LoaibdRepository;

@Service
public class LoaibdService {

	@Autowired
	private LoaibdRepository loaibdRepository;

	public List<FormLoaibd> getAllLoaibd() {
		List<FormLoaibd> formLoaibds = new ArrayList<>();
		List<Loaibd> loaibds = (List<Loaibd>) loaibdRepository.findAll();
		for (Loaibd loaibd : loaibds) {
			formLoaibds.add(new FormLoaibd(loaibd));
		}
		return formLoaibds;
	}
}
