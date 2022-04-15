package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Hopdongkygui;
import com.herokuapp.realestatebk.entity.Khachhang;
import com.herokuapp.realestatebk.entity.Nhanvien;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.form.FormKhachhang;
import com.herokuapp.realestatebk.repository.HopdongchuyennhhuongRepository;
import com.herokuapp.realestatebk.repository.HopdongkyguiRepository;
import com.herokuapp.realestatebk.repository.KhachhangRespository;

@Service
public class KhachhangService {

	@Autowired
	private KhachhangRespository khachhangRespository;

	@Autowired
	private HopdongkyguiRepository hopdongkyguiRepository;
	
	@Autowired
	private HopdongchuyennhhuongRepository hopdongchuyennhhuongRepository ;
	
	public List<Khachhang> getAllKhachhang() {
		return (List<Khachhang>) khachhangRespository.findAll();
	}

	public Khachhang addKhachhang(FormKhachhang fKhachhang) {
		return (Khachhang) khachhangRespository.save(fKhachhang.coverToKhachhang());
	}

	public Khachhang editKhachhang(FormKhachhang fKhachhang) {
		Khachhang khachhangEdit = null;
		boolean flag = khachhangRespository.existsById(fKhachhang.getKhid());
		if (flag) {
			khachhangEdit = khachhangRespository.save(fKhachhang.coverToKhachhang());
		}
		return khachhangEdit;
	}

	public Khachhang deleteNhanvien(int id) throws Exception {
		Khachhang khachhangDelete = null;
		boolean flag = khachhangRespository.existsById(id);
		if (flag) {
			khachhangDelete = khachhangRespository.findById(id).get();
			if (hopdongkyguiRepository.countHopdongkyguiByKhID(id) > 0) {
				throw new Exception(MessageException.messCanNotDeleteKhachhangHasHopdongkygui);
			} else if(hopdongchuyennhhuongRepository.countHopdongchuyennhuongByKhID(id) > 0) {
				throw new Exception(MessageException.messCanNotDeleteKhachhangHasHopdongchuyennhuong);
			} else {
				khachhangRespository.deleteById(id);
				return khachhangDelete;
			}
		} else {
			throw new Exception(MessageException.messKhachhangNotExists);
		}
	}

}
