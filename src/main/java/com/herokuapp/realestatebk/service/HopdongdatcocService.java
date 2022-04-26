package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.entity.Hopdongdatcoc;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.form.Formhopdongdatcoc;
import com.herokuapp.realestatebk.repository.BatdongsanRepository;
import com.herokuapp.realestatebk.repository.HopdongchuyennhhuongRepository;
import com.herokuapp.realestatebk.repository.HopdongdatcocRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class HopdongdatcocService {
	@Autowired
	private HopdongdatcocRepository hopdongdatcocRepository;

	@Autowired
	private BatdongsanRepository batdongsanRepository;
	
	@Autowired
	private HopdongchuyennhhuongRepository hopdongchuyennhhuongRepository;

	public List<Formhopdongdatcoc> getAllHopdongdatcoc() {
		List<Formhopdongdatcoc> formhopdongdatcocs = new ArrayList<>();
		List<Hopdongdatcoc> hopdongdatcocs = (List<Hopdongdatcoc>) hopdongdatcocRepository.findAll();
		for (Hopdongdatcoc hopdongdatcoc : hopdongdatcocs) {
			formhopdongdatcocs.add(new Formhopdongdatcoc(hopdongdatcoc));
		}
		return formhopdongdatcocs;
	}

	public Formhopdongdatcoc addHopdongdatcoc(Formhopdongdatcoc formhopdongdatcoc) throws Exception {
		Batdongsan batdongsan = batdongsanRepository.findById(formhopdongdatcoc.getBdsid()).get();
		if (batdongsan != null) {
			if (batdongsan.getHopdongkyguis().size() == 1) {
				if (batdongsan.getHopdongdatcocs().size() == 0) {
					Hopdongdatcoc hopdongdatcoc = hopdongdatcocRepository
							.save(formhopdongdatcoc.convertToHopdongdatcoc());
					batdongsan.setTinhtrang(1);
					return new Formhopdongdatcoc(hopdongdatcoc);
				} else {
					throw new Exception(MessageException.messBatdongsanHaveHDDatcoc);
				}
			} else {
				throw new Exception(MessageException.messBatdongsanNotHaveHDKyGui);
			}
		} else {
			throw new Exception(MessageException.messBatdongsanNotFound);
		}

	}

	public Formhopdongdatcoc deleteHopdongdatcoc(int id) throws Exception {
		int count = hopdongchuyennhhuongRepository.countHopdongchuyennhuongByHopdongdatcocId(id);
		if(count == 0) {
			Hopdongdatcoc hopdongdatcoc = hopdongdatcocRepository.findById(id).get();
			hopdongdatcocRepository.deleteById(id);
			return new Formhopdongdatcoc(hopdongdatcoc);
		} else {
			throw new Exception(MessageException.messHopdongdatcocHaveHopdongchuyennhuong);
		}
	}

	public Formhopdongdatcoc getHopdongdatcocById(int id) {
		Hopdongdatcoc hopdongdatcoc = hopdongdatcocRepository.findById(id).get();
		return new Formhopdongdatcoc(hopdongdatcoc);
	}
	
}
