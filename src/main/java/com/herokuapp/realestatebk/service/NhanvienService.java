package com.herokuapp.realestatebk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Nhanvien;
import com.herokuapp.realestatebk.form.FormLogin;
import com.herokuapp.realestatebk.repository.KhachhangRespository;
import com.herokuapp.realestatebk.repository.NhanvienRepository;


@Service
public class NhanvienService {
	
	@Autowired
	private NhanvienRepository nhanvienRepository;
	
	@Autowired
	private KhachhangRespository khachhangRespository;

	public List<Nhanvien> getAllNhanvien() {
		return (List<Nhanvien>) nhanvienRepository.findAll();
	}

	public String deleteNhanvien(int id) {
		int checkKhachhang = khachhangRespository.getKhachhangByNvID(id);
		if(checkKhachhang == 0) {
			nhanvienRepository.deleteById(id);
			return "Deleted Successfully";
		}else{
		Optional<Nhanvien> nhanvien = nhanvienRepository.findById(id);
		nhanvien.get().setTrangthai(Byte.valueOf("1")); 
		nhanvienRepository.save(nhanvien.get());
		return "Disabled Account Successfully";
		}
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

	public Nhanvien login(FormLogin formLogin) {
		Nhanvien nhanvien = nhanvienRepository.login(formLogin.getTaikhoan(), formLogin.getMatkhau());
		return nhanvien;
	}

}
