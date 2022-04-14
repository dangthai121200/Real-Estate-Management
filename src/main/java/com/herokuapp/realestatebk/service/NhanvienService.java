package com.herokuapp.realestatebk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.entity.Nhanvien;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.form.FormLogin;
import com.herokuapp.realestatebk.form.FormNhanvien;
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

	public Nhanvien deleteNhanvien(int id) throws Exception {
		Nhanvien nhanvienDelete = null;
		boolean flag = nhanvienRepository.existsById(id);
		if (flag) {
			nhanvienDelete = nhanvienRepository.findById(id).get();
			if (khachhangRespository.countKhachhangByNvID(id) > 0) {
				throw new Exception(MessageException.messCanNotDeleteNhanvienHasKhachHang);
			} else {
				nhanvienRepository.deleteById(id);
				return nhanvienDelete;
			}
		} else {
			throw new Exception(MessageException.messNhanvienNotExists);
		}
	}

	public Nhanvien addNhanvien(FormNhanvien fNhanvien) {
		Nhanvien nhanvienAdd = nhanvienRepository.save(fNhanvien.coverToNhanvien());
		return nhanvienAdd;
	}

	public Nhanvien editNhanvien(FormNhanvien fNhanvien) {
		Nhanvien nhanvienEdit = null;
		boolean flag = nhanvienRepository.existsById(fNhanvien.getNvid());
		if (flag) {
			nhanvienEdit = nhanvienRepository.save(fNhanvien.coverToNhanvien());
		}
		return nhanvienEdit;
	}

	public Nhanvien login(FormLogin formLogin) {
		Nhanvien nhanvien = nhanvienRepository.login(formLogin.getTaikhoan(), formLogin.getMatkhau());
		return nhanvien;
	}

}
