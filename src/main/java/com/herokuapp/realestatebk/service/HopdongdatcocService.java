package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Hopdongdatcoc;
import com.herokuapp.realestatebk.form.Formhopdongdatcoc;
import com.herokuapp.realestatebk.repository.HopdongdatcocRepository;

@Service
public class HopdongdatcocService {
	@Autowired
	private HopdongdatcocRepository hopdongdatcocRepository;

	public List<Formhopdongdatcoc> getAllHopdongdatcoc() {
		List<Formhopdongdatcoc> formhopdongdatcocs = new ArrayList<>();
		List<Hopdongdatcoc> hopdongdatcocs = (List<Hopdongdatcoc>) hopdongdatcocRepository.findAll();
		for (Hopdongdatcoc hopdongdatcoc : hopdongdatcocs) {
			formhopdongdatcocs.add(new Formhopdongdatcoc(hopdongdatcoc));
		}
		return formhopdongdatcocs;
	}
}
