package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Nhanvien;
import com.herokuapp.realestatebk.repository.NhanvienRepository;


@Service
public class NhanvienService {
	
	@Autowired
	private NhanvienRepository nhanvienRepository;

	public List<Nhanvien> getAllNhanvien() {
		return (List<Nhanvien>) nhanvienRepository.findAll();
	}

	public void deleteNhanvien(int id) {
		nhanvienRepository.deleteById(id);;
	}

	public Nhanvien addNhanvien(Nhanvien nhanvien) {
		Nhanvien nhanvienAdd = nhanvienRepository.save(nhanvien);
		return nhanvienAdd;
	}

	public Nhanvien editNhanvien(Nhanvien nhanvien) {
		Nhanvien nhanvienEdit = null;
		boolean flag = nhanvienRepository.existsById(nhanvien.getNvid());
		if(flag) {
			nhanvienEdit = nhanvienRepository.save(nhanvien);
		}
		return nhanvienEdit;
	}
	
	public Nhanvien checkExistNhanvien(String email, String pass) {
		Nhanvien checkedNhanvien = null;
		List<Nhanvien> listNhanvien = (List<Nhanvien>) nhanvienRepository.findAll();
		for (Nhanvien nv : listNhanvien) {
			if(email.equals(nv.getEmail()) && pass.equals(nv.getMatkhau()))
				checkedNhanvien = nv;
		}
		return checkedNhanvien;
	}

}
