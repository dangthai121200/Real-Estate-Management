package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Hopdongkygui;
import com.herokuapp.realestatebk.form.FormHopDongKyGui;
import com.herokuapp.realestatebk.repository.HopdongkyguiRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class HopdongkyguiService {

	@Autowired
	private HopdongkyguiRepository hopdongkyguiRepository;
	
	public List<FormHopDongKyGui> getAllHopdongkygui() {
		List<FormHopDongKyGui> formHopDongKyGuis = new ArrayList<>();
		List<Hopdongkygui> hopdongkyguis = (List<Hopdongkygui>) hopdongkyguiRepository.findAll();
		for (Hopdongkygui hopdongkygui : hopdongkyguis) {
			formHopDongKyGuis.add(new FormHopDongKyGui(hopdongkygui));
		}
		return formHopDongKyGuis;
	}
}
