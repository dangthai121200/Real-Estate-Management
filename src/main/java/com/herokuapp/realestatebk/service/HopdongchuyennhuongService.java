package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.entity.Hopdongchuyennhuong;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.exception.RealEsateException;
import com.herokuapp.realestatebk.form.FormHopdongchuyennhuong;
import com.herokuapp.realestatebk.repository.BatdongsanRepository;
import com.herokuapp.realestatebk.repository.HopdongchuyennhhuongRepository;
import com.herokuapp.realestatebk.util.Status;

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
			throws RealEsateException {
		Batdongsan batdongsan = batdongsanRepository.findById(formHopdongchuyennhuong.getBdsid()).get();
		if (batdongsan != null) {
			if (batdongsan.getHopdongdatcocs().size() > 0) // required batdongsan has hopdongdatcoc
			{
				if (batdongsan.getHopdongchuyennhuongs().size() == 0) // required batdongsan has not hopdongchuyennhuong
				{
					Hopdongchuyennhuong hopdongchuyennhuong = hopdongchuyennhhuongRepository
							.save(formHopdongchuyennhuong.convertToHopdongchuyennhuong());
					// Batdongsan has one hopdongdatcoc
					// but in entity hopdongdatoc is list so you should get at 0
					batdongsan.getHopdongdatcocs().get(0).setTrangthai((byte) Status.HDDC_HAS_HD_CHUYEN_NHUONG);
					batdongsan.setTinhtrang(Status.BDS_HAS_HD_CHUYEN_NHUONG);
					return new FormHopdongchuyennhuong(hopdongchuyennhuong);
				} else {
					throw new RealEsateException(MessageException.messHopdongchuyennhuongExists);
				}
			} else {
				throw new RealEsateException(MessageException.messHopdongchuyennhuongHaveNotHDDatcoc);
			}
		} else {
			throw new RealEsateException(MessageException.messBatdongsanNotFound);
		}

	}

	public FormHopdongchuyennhuong deleteHopdongchuyennhuong(int cnid) throws RealEsateException {
		boolean flag = hopdongchuyennhhuongRepository.existsById(cnid);
		if (flag) {
			Hopdongchuyennhuong hopdongchuyennhuong = hopdongchuyennhhuongRepository.findById(cnid).get();
			Batdongsan batdongsan = batdongsanRepository.findById(hopdongchuyennhuong.getBatdongsan().getBdsid()).get();
			hopdongchuyennhhuongRepository.deleteById(cnid);
			if (batdongsan.getHopdongdatcocs().size() > 0) {
				batdongsan.getHopdongdatcocs().get(0).setTrangthai((byte) Status.HDDC_HAS_NOT_HD_CHUYEN_NHUONG);
			}
			// if you delete hopdongchuyennhuong batdongsan set again tinhtrang has
			// hopdongdatcoc
			batdongsan.setTinhtrang(Status.BDS_HAS_HD_DAT_COC);
			return new FormHopdongchuyennhuong(hopdongchuyennhuong);
		} else {
			throw new RealEsateException(MessageException.messHopdongchuyennhuongNotExists);
		}
	}

	public FormHopdongchuyennhuong getHopdongchuyennhuongById(int id) {
		Hopdongchuyennhuong hopdongchuyennhuong = hopdongchuyennhhuongRepository.findById(id).get();
		return new FormHopdongchuyennhuong(hopdongchuyennhuong);
	}
}
