package com.herokuapp.realestatebk.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the loaibds database table.
 * 
 */
@Entity
@Table(name = "loaibds")
public class Loaibd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int loaiid;

	@Column(nullable = false, length = 50)
	private String tenloai;

	// bi-directional many-to-one association to Batdongsan
	@OneToMany(mappedBy = "loaibd", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Batdongsan> batdongsans;

	// bi-directional many-to-one association to Yeucaukhachhang
	@OneToMany(mappedBy = "loaibd", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Yeucaukhachhang> yeucaukhachhangs;

	public Loaibd() {
	}

	public Loaibd(int loaiid, String tenloai) {
		super();
		this.loaiid = loaiid;
		this.tenloai = tenloai;
	}

	public Loaibd(String tenloai) {
		this.tenloai = tenloai;
	}

	public int getLoaiid() {
		return this.loaiid;
	}

	public void setLoaiid(int loaiid) {
		this.loaiid = loaiid;
	}

	public String getTenloai() {
		return this.tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public List<Batdongsan> getBatdongsans() {
		return this.batdongsans;
	}

	public void setBatdongsans(List<Batdongsan> batdongsans) {
		this.batdongsans = batdongsans;
	}

	public Batdongsan addBatdongsan(Batdongsan batdongsan) {
		getBatdongsans().add(batdongsan);
		batdongsan.setLoaibd(this);

		return batdongsan;
	}

	public Batdongsan removeBatdongsan(Batdongsan batdongsan) {
		getBatdongsans().remove(batdongsan);
		batdongsan.setLoaibd(null);

		return batdongsan;
	}

	public List<Yeucaukhachhang> getYeucaukhachhangs() {
		return this.yeucaukhachhangs;
	}

	public void setYeucaukhachhangs(List<Yeucaukhachhang> yeucaukhachhangs) {
		this.yeucaukhachhangs = yeucaukhachhangs;
	}

	public Yeucaukhachhang addYeucaukhachhang(Yeucaukhachhang yeucaukhachhang) {
		getYeucaukhachhangs().add(yeucaukhachhang);
		yeucaukhachhang.setLoaibd(this);

		return yeucaukhachhang;
	}

	public Yeucaukhachhang removeYeucaukhachhang(Yeucaukhachhang yeucaukhachhang) {
		getYeucaukhachhangs().remove(yeucaukhachhang);
		yeucaukhachhang.setLoaibd(null);

		return yeucaukhachhang;
	}

}