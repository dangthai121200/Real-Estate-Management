package com.herokuapp.realestatebk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the nhanvien database table.
 * 
 */
@Entity
@Table(name="nhanvien")
@NamedQuery(name="Nhanvien.findAll", query="SELECT n FROM Nhanvien n")
public class Nhanvien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int nvid;

	@Column(nullable=false, length=50)
	private String diachi;

	private float doanhthu;

	@Column(nullable=false, length=50)
	private String email;

	@Column(nullable=false)
	private byte gioitinh;

	@Column(nullable=false, length=50)
	private String matkhau;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date ngaysinh;

	@Column(nullable=false)
	private byte quyen;

	@Column(nullable=false)
	private int sdt;

	@Column(nullable=false, length=20)
	private String taikhoan;

	@Column(nullable=false, length=50)
	private String tennv;

	@Column(nullable=false)
	private byte trangthai;

	//bi-directional many-to-one association to Khachhang
	@OneToMany(mappedBy="nhanvien")
	private List<Khachhang> khachhangs;

	public Nhanvien() {
	}

	public int getNvid() {
		return this.nvid;
	}

	public void setNvid(int nvid) {
		this.nvid = nvid;
	}

	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public float getDoanhthu() {
		return this.doanhthu;
	}

	public void setDoanhthu(float doanhthu) {
		this.doanhthu = doanhthu;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getGioitinh() {
		return this.gioitinh;
	}

	public void setGioitinh(byte gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getMatkhau() {
		return this.matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public Date getNgaysinh() {
		return this.ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public byte getQuyen() {
		return this.quyen;
	}

	public void setQuyen(byte quyen) {
		this.quyen = quyen;
	}

	public int getSdt() {
		return this.sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}

	public String getTennv() {
		return this.tennv;
	}

	public void setTennv(String tennv) {
		this.tennv = tennv;
	}

	public byte getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(byte trangthai) {
		this.trangthai = trangthai;
	}

	public List<Khachhang> getKhachhangs() {
		return this.khachhangs;
	}

	public void setKhachhangs(List<Khachhang> khachhangs) {
		this.khachhangs = khachhangs;
	}

	public Khachhang addKhachhang(Khachhang khachhang) {
		getKhachhangs().add(khachhang);
		khachhang.setNhanvien(this);

		return khachhang;
	}

	public Khachhang removeKhachhang(Khachhang khachhang) {
		getKhachhangs().remove(khachhang);
		khachhang.setNhanvien(null);

		return khachhang;
	}

}