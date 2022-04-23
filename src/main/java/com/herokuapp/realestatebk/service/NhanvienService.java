package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.herokuapp.realestatebk.auth.UserDetailsConfig;
import com.herokuapp.realestatebk.entity.Nhanvien;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.form.FormLogin;
import com.herokuapp.realestatebk.form.FormNhanvien;
import com.herokuapp.realestatebk.repository.KhachhangRespository;
import com.herokuapp.realestatebk.repository.NhanvienRepository;
import com.herokuapp.realestatebk.util.Role;

@Service
public class NhanvienService implements UserDetailsService {

	@Autowired
	private NhanvienRepository nhanvienRepository;

	@Autowired
	private KhachhangRespository khachhangRespository;

	public List<FormNhanvien> getAllNhanvien() {
		List<FormNhanvien> formNhanviens = new ArrayList<>();
		List<Nhanvien> nhanviens = (List<Nhanvien>) nhanvienRepository.findAll();
		for (Nhanvien nhanvien : nhanviens) {
			formNhanviens.add(new FormNhanvien(nhanvien));
		}
		return formNhanviens;
	}

	public FormNhanvien addNhanvien(FormNhanvien fNhanvien) {
		Nhanvien nhanvien = nhanvienRepository.save(fNhanvien.coverToNhanvien());
		FormNhanvien formNhanvienAdd = new FormNhanvien(nhanvien);
		return formNhanvienAdd;
	}

	public FormNhanvien editNhanvien(FormNhanvien fNhanvien) throws Exception {
		FormNhanvien formNhanvien = null;
		boolean flag = nhanvienRepository.existsById(fNhanvien.getNvid());
		if (flag) {
			UserDetailsConfig userDetails = (UserDetailsConfig) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			String taikhoan = userDetails.getFormNhanvien().getTaikhoan();
			String matkhau = userDetails.getFormNhanvien().getMatkhau();
			if (fNhanvien.getTaikhoan().equals(taikhoan) && fNhanvien.getMatkhau().equals(matkhau)
					|| userDetails.getAuthorities().contains(new SimpleGrantedAuthority(Role.ROLE_ADMIN))) {
				Nhanvien nhanvien = nhanvienRepository.save(fNhanvien.coverToNhanvien());
				formNhanvien = new FormNhanvien(nhanvien);
				return formNhanvien;
			} else {
				throw new Exception(MessageException.messCannotupdateNhanvien);
			}

		} else {
			throw new Exception(MessageException.messNhanvienNotExists);
		}
	}

	public FormNhanvien deleteNhanvien(int id) throws Exception {
		FormNhanvien formNhanvienDelete = null;
		boolean flag = nhanvienRepository.existsById(id);
		if (flag) {
			if (khachhangRespository.countKhachhangByNvID(id) > 0) {
				throw new Exception(MessageException.messCanNotDeleteNhanvienHasKhachHang);
			} else {
				Nhanvien nhanvien = nhanvienRepository.findById(id).get();
				nhanvienRepository.deleteById(id);
				formNhanvienDelete = new FormNhanvien(nhanvien);
				return formNhanvienDelete;
			}
		} else {
			throw new Exception(MessageException.messNhanvienNotExists);
		}
	}

	public FormNhanvien login(FormLogin formLogin) {
		Nhanvien nhanvien = nhanvienRepository.login(formLogin.getTaikhoan(), formLogin.getMatkhau());
		FormNhanvien formNhanvien = new FormNhanvien(nhanvien);
		return formNhanvien;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Nhanvien nhanvien = nhanvienRepository.findNhanvienByTaikhoan(username);
		if (nhanvien == null) {
			throw new UsernameNotFoundException(MessageException.messNhanvienNotExists);
		}
		FormNhanvien formNhanvien = new FormNhanvien();
		formNhanvien.converToFormNhanvien(nhanvien);
		Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(formNhanvien.getQuyen()));
		UserDetailsConfig nhanvienDetails = new UserDetailsConfig(formNhanvien, authorities);
		return nhanvienDetails;
	}
}
