package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Khachhang;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.form.FormKhachhang;
import com.herokuapp.realestatebk.repository.HopdongchuyennhhuongRepository;
import com.herokuapp.realestatebk.repository.HopdongkyguiRepository;
import com.herokuapp.realestatebk.repository.KhachhangRespository;

@Service
@Transactional(rollbackFor = Exception.class)
public class KhachhangService {

	@Autowired
	private KhachhangRespository khachhangRespository;

	@Autowired
	private HopdongchuyennhhuongRepository hopdongchuyennhhuongRepository;

	@Autowired
	private HopdongkyguiRepository hopdongkyguiRepository;

	public List<FormKhachhang> getAllKhachhang() {
		List<FormKhachhang> formKhachhangs = new ArrayList<>();
		List<Khachhang> khachhangs = (List<Khachhang>) khachhangRespository.findAll();
		for (Khachhang khachhang : khachhangs) {
			formKhachhangs.add(new FormKhachhang(khachhang));
		}
		return formKhachhangs;
	}

	public FormKhachhang addKhachhang(FormKhachhang fKhachhang) {
		Khachhang khachhang = khachhangRespository.save(fKhachhang.coverToKhachhang());
		FormKhachhang formKhachhangAdd = new FormKhachhang(khachhang);
		return formKhachhangAdd;
	}

	public FormKhachhang editKhachhang(FormKhachhang fKhachhang) {
		Khachhang khachhangEdit = null;
		FormKhachhang formKhachhangEdit = null;
		boolean flag = khachhangRespository.existsById(fKhachhang.getKhid());
		if (flag) {
			khachhangEdit = khachhangRespository.save(fKhachhang.coverToKhachhang());
			formKhachhangEdit = new FormKhachhang(khachhangEdit);
		}
		return formKhachhangEdit;
	}

	public FormKhachhang deleteKhachHang(int id) throws Exception {
		boolean flag = khachhangRespository.existsById(id);
		if (flag) {
			if (hopdongkyguiRepository.countHopdongkyguiByKhID(id) > 0) {
				throw new Exception(MessageException.messCanNotDeleteKhachhangHasHopdongkygui);
			} else if(hopdongchuyennhhuongRepository.countHopdongchuyennhuongByKhID(id) > 0) {
				throw new Exception(MessageException.messCanNotDeleteKhachhangHasHopdongchuyennhuong);
			} else {
				Khachhang khachhang = khachhangRespository.findById(id).get();
				khachhangRespository.deleteById(id);
				FormKhachhang formKhachhangDelete = new FormKhachhang(khachhang);
				return formKhachhangDelete;
			}
		} else {
			throw new Exception(MessageException.messKhachhangNotExists);
		}
	}

	public FormKhachhang getKhachhangByID(int id) throws Exception {
		boolean flag = khachhangRespository.existsById(id);
		if (flag) {
			Khachhang khachhang = khachhangRespository.findById(id).get();
			FormKhachhang formKhachhang = new FormKhachhang(khachhang);
			return formKhachhang;
		} else 
			throw new Exception(MessageException.messKhachhangNotExists);
	}

}
