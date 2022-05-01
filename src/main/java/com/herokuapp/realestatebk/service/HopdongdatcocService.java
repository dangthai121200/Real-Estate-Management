package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.entity.Hopdongdatcoc;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.exception.RealEsateException;
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

	public Formhopdongdatcoc addHopdongdatcoc(Formhopdongdatcoc formhopdongdatcoc) throws RealEsateException {
		Batdongsan batdongsan = batdongsanRepository.findById(formhopdongdatcoc.getBdsid()).get();
		if (batdongsan != null) {
			if (batdongsan.getHopdongkyguis().size() == 1) {
				if (batdongsan.getHopdongdatcocs().size() == 0) {
					Hopdongdatcoc hopdongdatcoc = hopdongdatcocRepository
							.save(formhopdongdatcoc.convertToHopdongdatcoc());
					if (batdongsan.getHopdongkyguis().size() > 0) {
						batdongsan.getHopdongkyguis().get(0).setTrangthai((byte) 1);
					}
					batdongsan.setTinhtrang(1);
					return new Formhopdongdatcoc(hopdongdatcoc);
				} else {
					throw new RealEsateException(MessageException.messBatdongsanHaveHDDatcoc);
				}
			} else {
				throw new RealEsateException(MessageException.messBatdongsanNotHaveHDKyGui);
			}
		} else {
			throw new RealEsateException(MessageException.messBatdongsanNotFound);
		}

	}

	public Formhopdongdatcoc deleteHopdongdatcoc(int id) throws RealEsateException {
		int count = hopdongchuyennhhuongRepository.countHopdongchuyennhuongByHopdongdatcocId(id);
		if (count == 0) {
			Hopdongdatcoc hopdongdatcoc = hopdongdatcocRepository.findById(id).get();
			Batdongsan batdongsan = batdongsanRepository.findById(hopdongdatcoc.getBatdongsan().getBdsid()).get();
			hopdongdatcocRepository.deleteById(id);
			if (batdongsan.getHopdongkyguis().size() > 0) {
				batdongsan.getHopdongkyguis().get(0).setTrangthai((byte) 0);
			}
			batdongsan.setTinhtrang(0);
			return new Formhopdongdatcoc(hopdongdatcoc);
		} else {
			throw new RealEsateException(MessageException.messHopdongdatcocHaveHopdongchuyennhuong);
		}
	}

	public Formhopdongdatcoc getHopdongdatcocById(int id) {
		Hopdongdatcoc hopdongdatcoc = hopdongdatcocRepository.findById(id).get();
		return new Formhopdongdatcoc(hopdongdatcoc);
	}

}
