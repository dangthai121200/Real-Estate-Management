package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.form.FormBatdongsan;
import com.herokuapp.realestatebk.repository.BatdongsanRepository;

@Service
public class BatdongsanService {

	@Autowired
	private BatdongsanRepository batdongsanReponsitory;

	public List<FormBatdongsan> getAllBatdongsan() {
		List<FormBatdongsan> formBatdongsans = new ArrayList<>();
		List<Batdongsan> batdongsans = (List<Batdongsan>) batdongsanReponsitory.findAll();
		for (Batdongsan batdongsan : batdongsans) {
			formBatdongsans.add(new FormBatdongsan(batdongsan));
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

	public FormBatdongsan getBatdongsanByID(int id) throws Exception {

		if (batdongsanReponsitory.existsById(id)) {
			Batdongsan batdongsan = batdongsanReponsitory.findById(id).get();
			FormBatdongsan formBatdongsan = new FormBatdongsan(batdongsan);
			return formBatdongsan;
		} else {
			throw new Exception(MessageException.messBatdongsanNotFound);
		}
	}
}
