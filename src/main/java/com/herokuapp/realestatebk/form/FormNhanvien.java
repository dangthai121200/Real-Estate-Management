package com.herokuapp.realestatebk.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.herokuapp.realestatebk.entity.Nhanvien;

public class FormNhanvien {

	private int nvid;
	private String diachi;
	private float doanhthu;
	private String email;
	private byte gioitinh;
	private String matkhau;
	@Temporal(TemporalType.DATE)
	private Date ngaysinh;
	private String quyen;
	private int sdt;
	private String taikhoan;
	private String tennv;
	private byte trangthai;

	public FormNhanvien() {
		super();
	}

	public FormNhanvien(Nhanvien nhanvien) {
		this.nvid = nhanvien.getNvid();
		this.diachi = nhanvien.getDiachi();
		this.doanhthu = nhanvien.getDoanhthu();
		this.email = nhanvien.getEmail();
		this.gioitinh = nhanvien.getGioitinh();
		this.matkhau = nhanvien.getMatkhau();
		this.ngaysinh = nhanvien.getNgaysinh();
		this.quyen = nhanvien.getQuyen();
		this.sdt = nhanvien.getSdt();
		this.taikhoan = nhanvien.getTaikhoan();
		this.tennv = nhanvien.getTennv();
		this.trangthai = nhanvien.getTrangthai();
	}

	public String getDiachi() {
		return diachi;
	}

	public int getNvid() {
		return nvid;
	}

	public void setNvid(int nvid) {
		this.nvid = nvid;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public float getDoanhthu() {
		return doanhthu;
	}

	public void setDoanhthu(float doanhthu) {
		this.doanhthu = doanhthu;
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

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}

	public String getTennv() {
		return tennv;
	}

	public void setTennv(String tennv) {
		this.tennv = tennv;
	}

	public byte getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(byte trangthai) {
		this.trangthai = trangthai;
	}

	public void converToFormNhanvien(Nhanvien nhanvien) {
		this.nvid = nhanvien.getNvid();
		this.diachi = nhanvien.getDiachi();
		this.doanhthu = nhanvien.getDoanhthu();
		this.email = nhanvien.getEmail();
		this.gioitinh = nhanvien.getGioitinh();
		this.matkhau = nhanvien.getMatkhau();
		this.ngaysinh = nhanvien.getNgaysinh();
		this.quyen = nhanvien.getQuyen();
		this.sdt = nhanvien.getSdt();
		this.taikhoan = nhanvien.getTaikhoan();
		this.tennv = nhanvien.getTennv();
		this.trangthai = nhanvien.getTrangthai();
	}

	public Nhanvien coverToNhanvien() {
		Nhanvien nhanvien = null;
		if (Integer.valueOf(nvid) == null) {
			// use for add nhanvien
			nhanvien = new Nhanvien(diachi, doanhthu, email, gioitinh, matkhau, ngaysinh, quyen, sdt, taikhoan, tennv,
					trangthai);
		} else {
			// use for update nhanvien
			nhanvien = new Nhanvien(nvid, diachi, doanhthu, email, gioitinh, matkhau, ngaysinh, quyen, sdt, taikhoan,
					tennv, trangthai);
		}
		return nhanvien;
	}
}
