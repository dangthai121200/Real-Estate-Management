package com.herokuapp.realestatebk.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.herokuapp.realestatebk.entity.Khachhang;

public class FormKhachhang {

	private int khid;

	@Max(value = 999999999, message = "Chứng minh nhân dân phải đủ 9 số")
	@Min(value = 99999999, message = "Chứng minh nhân dân phải đủ 9 số")
	private int cmnd;

	@NotEmpty(message = "Thiếu địa chỉ")
	private String diachi;

	@NotEmpty(message = "Thiếu địa chỉ thường trú")
	private String diachitt;

	@Email(message = "Email hông hợp lệ")
	private String email;

	@NotNull(message = "Thiếu giới tính")
	private byte gioitinh;

	@NotEmpty(message = "Thiếu họ tên")
	private String hoten;

	@NotNull(message = "Thiếu loại khách hàng")
	private byte loaikh;

	private String mota;

	@NotNull(message = "Thiếu ngày sinh")
	private Date ngaysinh;

	@NotNull(message = "thiếu số điện thoại")
	private int sodienthoai;

	@NotNull(message = "thiếu trạng thái")
	private byte trangthai;

	private int nvid;

	public FormKhachhang() {

	}

	public FormKhachhang(Khachhang khachhang) {
		super();
		this.khid = khachhang.getKhid();
		this.cmnd = khachhang.getCmnd();
		this.diachi = khachhang.getDiachi();
		this.diachitt = khachhang.getDiachitt();
		this.email = khachhang.getEmail();
		this.gioitinh = khachhang.getGioitinh();
		this.hoten = khachhang.getHoten();
		this.loaikh = khachhang.getLoaikh();
		this.mota = khachhang.getMota();
		this.ngaysinh = khachhang.getNgaysinh();
		this.sodienthoai = khachhang.getSodienthoai();
		this.trangthai = khachhang.getTrangthai();
		this.nvid = khachhang.getNhanvien().getNvid();
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

	public int getNvid() {
		return nvid;
	}

	public void setNvid(int nvid) {
		this.nvid = nvid;
	}

	public Khachhang coverToKhachhang() {
		Khachhang khachhang = null;
		if (Integer.valueOf(this.khid) == null) {
			// use for add khachhang
			khachhang = new Khachhang(cmnd, diachi, diachitt, email, gioitinh, hoten, loaikh, mota, ngaysinh,
					sodienthoai, trangthai, nvid);
		} else {
			// use for update khachhang
			khachhang = new Khachhang(khid, cmnd, diachi, diachitt, email, gioitinh, hoten, loaikh, mota, ngaysinh,
					sodienthoai, trangthai, nvid);
		}
		return khachhang;
	}

	public void convertToFormKhachHang(Khachhang khachhang) {
		this.khid = khachhang.getKhid();
		this.cmnd = khachhang.getCmnd();
		this.diachi = khachhang.getDiachi();
		this.diachitt = khachhang.getDiachitt();
		this.email = khachhang.getEmail();
		this.gioitinh = khachhang.getGioitinh();
		this.hoten = khachhang.getHoten();
		this.loaikh = khachhang.getLoaikh();
		this.mota = khachhang.getMota();
		this.ngaysinh = khachhang.getNgaysinh();
		this.sodienthoai = khachhang.getSodienthoai();
		this.trangthai = khachhang.getTrangthai();
		this.nvid = khachhang.getNhanvien().getNvid();
	}

}
