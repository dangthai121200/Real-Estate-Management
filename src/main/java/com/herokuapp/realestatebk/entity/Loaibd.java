package com.herokuapp.realestatebk.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the loaibds database table.
 * 
 */
@Entity
@Table(name="loaibds")
@NamedQuery(name="Loaibd.findAll", query="SELECT l FROM Loaibd l")
public class Loaibd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int loaiid;

	@Column(nullable=false, length=50)
	private String tenloai;

	//bi-directional many-to-one association to Batdongsan
	@OneToMany(mappedBy="loaibd", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Batdongsan> batdongsans;

	//bi-directional many-to-one association to Yeucaukhachhang
	@OneToMany(mappedBy="loaibd", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Yeucaukhachhang> yeucaukhachhangs;

	public Loaibd() {
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