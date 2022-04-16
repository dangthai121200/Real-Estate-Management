package com.herokuapp.realestatebk.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.herokuapp.realestatebk.entity.Khachhang;

public class FormKhachhang {
	private int khid;
	private int cmnd;
	private String diachi;
	private String diachitt;
	private String email;
	private byte gioitinh;
	private String hoten;
	private byte loaikh;
	private String mota;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaysinh;
	private int sodienthoai;
	private byte trangthai;

	public FormKhachhang() {
		super();
	}

	public FormKhachhang(int khid, int cmnd, String diachi, String diachitt, String email, byte gioitinh, String hoten,
			byte loaikh, String mota, Date ngaysinh, int sodienthoai, byte trangthai) {
		super();
		this.khid = khid;
		this.cmnd = cmnd;
		this.diachi = diachi;
		this.diachitt = diachitt;
		this.email = email;
		this.gioitinh = gioitinh;
		this.hoten = hoten;
		this.loaikh = loaikh;
		this.mota = mota;
		this.ngaysinh = ngaysinh;
		this.sodienthoai = sodienthoai;
		this.trangthai = trangthai;
	}

	public int getKhid() {
		return khid;
	}

	public void setKhid(int khid) {
		this.khid = khid;
	}

	public int getCmnd() {
		return cmnd;
	}

	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getDiachitt() {
		return diachitt;
	}

	public void setDiachitt(String diachitt) {
		this.diachitt = diachitt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(byte gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public byte getLoaikh() {
		return loaikh;
	}

	public void setLoaikh(byte loaikh) {
		this.loaikh = loaikh;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public int getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(int sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public byte getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(byte trangthai) {
		this.trangthai = trangthai;
	}

	public Khachhang coverToKhachhang() {
		Khachhang khachhang = null;
		if (Integer.valueOf(this.khid) == null) {
			// use for add khachhang
			khachhang = new Khachhang(cmnd, diachi, diachitt, email, gioitinh, hoten, loaikh, mota, ngaysinh,
					sodienthoai, trangthai);
		} else {
			// use for update khachhang
			khachhang = new Khachhang(khid, cmnd, diachi, diachitt, email, gioitinh, hoten, loaikh, mota, ngaysinh,
					sodienthoai, trangthai);
		}
		return khachhang;
	}

}
