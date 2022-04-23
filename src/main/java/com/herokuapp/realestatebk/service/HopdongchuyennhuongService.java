package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Hopdongchuyennhuong;
import com.herokuapp.realestatebk.form.FormHopdongchuyennhuong;
import com.herokuapp.realestatebk.repository.HopdongchuyennhhuongRepository;

@Service
public class HopdongchuyennhuongService {

	@Autowired
	private HopdongchuyennhhuongRepository hopdongchuyennhhuongRepository;

	public List<FormHopdongchuyennhuong> getAllHopdongchuyennhuong() {
		List<FormHopdongchuyennhuong> formHopdongchuyennhuongs = new ArrayList<>();
		List<Hopdongchuyennhuong> hopdongchuyennhuongs = (List<Hopdongchuyennhuong>) hopdongchuyennhhuongRepository
				.findAll();
		for (Hopdongchuyennhuong hopdongchuyennhuong : hopdongchuyennhuongs) {
			formHopdongchuyennhuongs.add(new FormHopdongchuyennhuong(hopdongchuyennhuong));
		}
		return formHopdongchuyennhuongs;
	}
}
