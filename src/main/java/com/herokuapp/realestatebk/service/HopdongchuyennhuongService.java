package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.entity.Hopdongchuyennhuong;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.form.FormHopdongchuyennhuong;
import com.herokuapp.realestatebk.repository.BatdongsanRepository;
import com.herokuapp.realestatebk.repository.HopdongchuyennhhuongRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class HopdongchuyennhuongService {

	@Autowired
	private HopdongchuyennhhuongRepository hopdongchuyennhhuongRepository;

	@Autowired
	private BatdongsanRepository batdongsanRepository;

	public List<FormHopdongchuyennhuong> getAllHopdongchuyennhuong() {
		List<FormHopdongchuyennhuong> formHopdongchuyennhuongs = new ArrayList<>();
		List<Hopdongchuyennhuong> hopdongchuyennhuongs = (List<Hopdongchuyennhuong>) hopdongchuyennhhuongRepository
				.findAll();
		for (Hopdongchuyennhuong hopdongchuyennhuong : hopdongchuyennhuongs) {
			formHopdongchuyennhuongs.add(new FormHopdongchuyennhuong(hopdongchuyennhuong));
		}
		return formHopdongchuyennhuongs;
	}

	public FormHopdongchuyennhuong addHopdongchuyennhuong(FormHopdongchuyennhuong formHopdongchuyennhuong)
			throws Exception {
		Batdongsan batdongsan = batdongsanRepository.findById(formHopdongchuyennhuong.getBdsid()).get();
		if (batdongsan != null) {
			if (batdongsan.getHopdongdatcocs().size() == 1) {
				if (batdongsan.getHopdongchuyennhuongs().size() == 0) {
					Hopdongchuyennhuong hopdongchuyennhuong = hopdongchuyennhhuongRepository
							.save(formHopdongchuyennhuong.convertToHopdongchuyennhuong());
					batdongsan.setTinhtrang(2);
					return new FormHopdongchuyennhuong(hopdongchuyennhuong);
				} else {
					throw new Exception(MessageException.messHopdongchuyennhuongExists);
				}

			} else {
				throw new Exception(MessageException.messHopdongchuyennhuongHaveNotHDDatcoc);
			}
		} else {
			throw new Exception(MessageException.messBatdongsanNotFound);
		}

	}

	public FormHopdongchuyennhuong deleteHopdongchuyennhuong(int cnid) throws Exception {
		boolean flag = hopdongchuyennhhuongRepository.existsById(cnid);
		if (flag) {
			Hopdongchuyennhuong hopdongchuyennhuong = hopdongchuyennhhuongRepository.findById(cnid).get();
			hopdongchuyennhhuongRepository.deleteById(cnid);
			return new FormHopdongchuyennhuong(hopdongchuyennhuong);
		} else {
			throw new Exception(MessageException.messHopdongchuyennhuongNotExists);
		}
	}

	public FormHopdongchuyennhuong getHopdongchuyennhuongById(int id) {
		Hopdongchuyennhuong hopdongchuyennhuong = hopdongchuyennhhuongRepository.findById(id).get();
		return new FormHopdongchuyennhuong(hopdongchuyennhuong);
	}
}
