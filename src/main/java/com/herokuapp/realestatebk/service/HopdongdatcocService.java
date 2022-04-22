package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.herokuapp.realestatebk.entity.Hopdongdatcoc;
import com.herokuapp.realestatebk.repository.HopdongdatcocRepository;

@Service
public class HopdongdatcocService {
	@Autowired
	private HopdongdatcocRepository hopdongdatcocRepository;
	
	public List<Hopdongdatcoc> getAllHopdongdatcoc() {
		return (List<Hopdongdatcoc>) hopdongdatcocRepository.findAll();
	}
}
