package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Yeucaukhachhang;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.form.FormYeucaukhachhang;
import com.herokuapp.realestatebk.repository.YeucaukhachhangRepository;

@Service
public class YeucaukhachhangService {
	
	@Autowired
	private YeucaukhachhangRepository yeucaukhachhangRepository;
	
	public List<FormYeucaukhachhang> getAllYeucaukhachhang() {
		List<FormYeucaukhachhang> formYeucaukhachhangs = new ArrayList<FormYeucaukhachhang>();
		List<Yeucaukhachhang> yeucaukhachhangs = (List<Yeucaukhachhang>) yeucaukhachhangRepository.findAll();
		for (Yeucaukhachhang yeucaukhachhang : yeucaukhachhangs) {
			formYeucaukhachhangs.add(new FormYeucaukhachhang(yeucaukhachhang));
		}
		return formYeucaukhachhangs;
	}

	public FormYeucaukhachhang addyeucaukhachhang(FormYeucaukhachhang fYeucaukhachhang) {
		Yeucaukhachhang yeucaukhachhang = yeucaukhachhangRepository.save(fYeucaukhachhang.coverToYeucaukhachhang());
		return new FormYeucaukhachhang(yeucaukhachhang);
	}

	public FormYeucaukhachhang editYeucaukhachhang(FormYeucaukhachhang fYeucaukhachhang) {
		FormYeucaukhachhang formyeucaukhachhangEdit = null;
		boolean flag = yeucaukhachhangRepository.existsById(fYeucaukhachhang.getYcid());
		if (flag) {
			Yeucaukhachhang yeucaukhachhang = yeucaukhachhangRepository.save(fYeucaukhachhang.coverToYeucaukhachhang());
			formyeucaukhachhangEdit = new FormYeucaukhachhang(yeucaukhachhang);
		}
		return formyeucaukhachhangEdit;
	}

	public FormYeucaukhachhang deleteYeucaukhachhang(int id) throws Exception {
		FormYeucaukhachhang formyeucaukhachhangDel = null;
		boolean flag = yeucaukhachhangRepository.existsById(id);
		if (flag) {
			Yeucaukhachhang yeucaukhachhang = yeucaukhachhangRepository.findById(id).get();
			formyeucaukhachhangDel = new FormYeucaukhachhang(yeucaukhachhang);
			yeucaukhachhangRepository.deleteById(id);
		}else
			throw new Exception(MessageException.messYeucaukhachhangNotExists);
		return formyeucaukhachhangDel;
	}

}
