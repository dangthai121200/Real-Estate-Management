package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Khachhang;
import com.herokuapp.realestatebk.entity.Nhanvien;
import com.herokuapp.realestatebk.repository.KhachhangRespository;

@Service
public class KhachhangService {
	
	@Autowired
	private KhachhangRespository khachhangRespository;
	
	public List<Khachhang> getAllKhachhang(){
		return (List<Khachhang>) khachhangRespository.findAll();
	}

	public Khachhang addKhachhang(Khachhang khachhang) {
		return (Khachhang) khachhangRespository.save(khachhang);
	}

	public Khachhang editKhachhang(Khachhang khachhang) {
		Khachhang khachhangEdit = null;
		boolean flag = khachhangRespository.existsById(khachhang.getKhid());
		if(flag) {
			khachhangEdit = khachhangRespository.save(khachhang);
		}
		return khachhangEdit;
	}

}
