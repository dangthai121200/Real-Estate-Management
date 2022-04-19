package com.herokuapp.realestatebk.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.herokuapp.realestatebk.form.FormNhanvien;

public class UserDetailsConfig extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FormNhanvien formNhanvien;

	public UserDetailsConfig(FormNhanvien formNhanvien, Collection<? extends GrantedAuthority> authorities) {
		super(formNhanvien.getTaikhoan(), formNhanvien.getMatkhau(), authorities);
		this.formNhanvien = formNhanvien;
	}

	public FormNhanvien getFormNhanvien() {
		return formNhanvien;
	}

	public void setFormNhanvien(FormNhanvien formNhanvien) {
		this.formNhanvien = formNhanvien;
	}

}
