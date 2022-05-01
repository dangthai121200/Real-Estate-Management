package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.exception.RealEsateException;
import com.herokuapp.realestatebk.form.FormBatdongsan;
import com.herokuapp.realestatebk.form.FormHinhBd;
import com.herokuapp.realestatebk.repository.BatdongsanRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class BatdongsanService {

	@Autowired
	private BatdongsanRepository batdongsanReponsitory;

	public List<FormBatdongsan> getAllBatdongsan() {
		List<FormBatdongsan> formBatdongsans = new ArrayList<>();
		List<Batdongsan> batdongsans = (List<Batdongsan>) batdongsanReponsitory.findAll();
		for (Batdongsan batdongsan : batdongsans) {
			FormBatdongsan formBatdongsan = new FormBatdongsan(batdongsan);
			List<FormHinhBd> formHinhBds = new ArrayList<>();
			batdongsan.getHinhbds().forEach(hinhBds -> {
				formHinhBds.add(new FormHinhBd(hinhBds));
			});
			formBatdongsan.setFormhinhBdList(formHinhBds);
			formBatdongsans.add(formBatdongsan);
		}
		return formBatdongsans;
	}

	public FormBatdongsan addBatdongsan(FormBatdongsan fBatdongsan) {
		Batdongsan batdongsan = batdongsanReponsitory.save(fBatdongsan.coverToBatdongsan());
		FormBatdongsan formBatdongsanAdd = new FormBatdongsan(batdongsan);
		return formBatdongsanAdd;
	}

	public FormBatdongsan editBatdongsan(FormBatdongsan fBatdongsan) {
		FormBatdongsan formBatdongsanEdit = null;
		boolean flag = batdongsanReponsitory.existsById(fBatdongsan.getBdsid());
		if (flag) {
			Batdongsan batdongsan = batdongsanReponsitory.save(fBatdongsan.coverToBatdongsan());
			formBatdongsanEdit = new FormBatdongsan(batdongsan);
		}
		return formBatdongsanEdit;
	}

	public FormBatdongsan getBatdongsanByID(int id) throws RealEsateException {

		if (batdongsanReponsitory.existsById(id)) {
			Batdongsan batdongsan = batdongsanReponsitory.findById(id).get();
			FormBatdongsan formBatdongsan = new FormBatdongsan(batdongsan);
			return formBatdongsan;
		} else {
			throw new RealEsateException(MessageException.messBatdongsanNotFound);
		}
	}
}
