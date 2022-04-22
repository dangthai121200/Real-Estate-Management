package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Khachhang;
import com.herokuapp.realestatebk.entity.Loaibd;
import com.herokuapp.realestatebk.entity.Yeucaukhachhang;
import com.herokuapp.realestatebk.form.FormYeucaukhachhang;
import com.herokuapp.realestatebk.repository.KhachhangRespository;
import com.herokuapp.realestatebk.repository.LoaibdRepository;
import com.herokuapp.realestatebk.repository.YeucaukhachhangRepository;

@Service
public class YeucaukhachhangService {
	
	@Autowired
	private YeucaukhachhangRepository yeucaukhachhangRepository;
	
	@Autowired
	private KhachhangRespository khachhangRespository;
	
	@Autowired
	private LoaibdRepository loaibdRepository;
	
	public List<Yeucaukhachhang> getAllYeucaukhachhang() {
		return (List<Yeucaukhachhang>) yeucaukhachhangRepository.findAll();
	}

	public Yeucaukhachhang addyeucaukhachhang(FormYeucaukhachhang fYeucaukhachhang) {
		Khachhang khachhang = khachhangRespository.findById(fYeucaukhachhang.getKhachhang()).get();
		Loaibd loaibd = loaibdRepository.findById(fYeucaukhachhang.getLoaibd()).get();
		return yeucaukhachhangRepository.save(fYeucaukhachhang.coverToYeucaukhachhang(khachhang, loaibd));
	}

}
