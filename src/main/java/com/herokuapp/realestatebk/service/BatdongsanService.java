package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.entity.Khachhang;
import com.herokuapp.realestatebk.entity.Loaibd;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.form.FormBatdongsan;
import com.herokuapp.realestatebk.repository.BatdongsanRepository;
import com.herokuapp.realestatebk.repository.KhachhangRespository;
import com.herokuapp.realestatebk.repository.LoaibdRepository;

@Service
public class BatdongsanService {

	@Autowired
	private BatdongsanRepository batdongsanReponsitory;
	
	@Autowired
	private KhachhangRespository khachhangRespository;
	
	@Autowired
	private LoaibdRepository loaibdRepository;

	public List<Batdongsan> getAllBatdongsan() {

		return (List<Batdongsan>) batdongsanReponsitory.findAll();
	}

	public Batdongsan addBatdongsan(FormBatdongsan fBatdongsan) {
		Loaibd loaibd = loaibdRepository.findById(fBatdongsan.getLoaibd()).get();
		Khachhang khachhang = khachhangRespository.findById(fBatdongsan.getKhachhang()).get();
		return batdongsanReponsitory.save(fBatdongsan.coverToBatdongsan(loaibd, khachhang));
	}

	public Batdongsan editBatdongsan(FormBatdongsan fBatdongsan) {
		Batdongsan batdongsanEdit = null;
		boolean flag = batdongsanReponsitory.existsById(fBatdongsan.getBdsid());
		if (flag) {
			Loaibd loaibd = loaibdRepository.findById(fBatdongsan.getLoaibd()).get();
			Khachhang khachhang = khachhangRespository.findById(fBatdongsan.getKhachhang()).get();
			batdongsanEdit = batdongsanReponsitory.save(fBatdongsan.coverToBatdongsan(loaibd, khachhang));
		}
		return batdongsanEdit;
	}


	public Batdongsan getBatdongsanByID(int id) throws Exception {
		if(batdongsanReponsitory.existsById(id))
			return batdongsanReponsitory.findById(id).get();
		else
			throw new Exception(MessageException.messBatdongsanNotFound);
	}
}
