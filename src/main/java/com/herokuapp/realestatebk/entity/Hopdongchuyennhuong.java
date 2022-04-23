package com.herokuapp.realestatebk.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the hopdongchuyennhuong database table.
 * 
 */
@Entity(name = "hopdongchuyennhuong")
@Table(name = "hopdongchuyennhuong")
public class Hopdongchuyennhuong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int cnid;

	@Column(nullable = false)
	private float giatri;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date ngaylap;

	@Column(nullable = false)
	private byte trangthai;

	// bi-directional many-to-one association to Batdongsan
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bdsid")
	@JsonIgnore
	private Batdongsan batdongsan;

	// bi-directional many-to-one association to Hopdongdatcoc
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dcid")
	@JsonIgnore
	private Hopdongdatcoc hopdongdatcoc;

	// bi-directional many-to-one association to Khachhang
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "khid")
	@JsonIgnore
	private Khachhang khachhang;

	public Hopdongchuyennhuong() {
	}

	public Hopdongchuyennhuong(float giatri, Date ngaylap, byte trangthai, int bdsid, int dcid, int khid) {
		this.giatri = giatri;
		this.ngaylap = ngaylap;
		this.trangthai = trangthai;
		if (this.batdongsan == null) {
			this.batdongsan = new Batdongsan();
		}
		this.batdongsan.setBdsid(bdsid);
		if (this.hopdongdatcoc == null) {
			this.hopdongdatcoc = new Hopdongdatcoc();
		}
		this.hopdongdatcoc.setDcid(dcid);
		if (this.khachhang == null) {
			this.khachhang = new Khachhang();
		}
		this.khachhang.setKhid(khid);
	}

	public Hopdongchuyennhuong(int cnid, float giatri, Date ngaylap, byte trangthai, int bdsid, int dcid, int khid) {
		super();
		this.cnid = cnid;
		this.giatri = giatri;
		this.ngaylap = ngaylap;
		this.trangthai = trangthai;
		if (this.batdongsan == null) {
			this.batdongsan = new Batdongsan();
		}
		this.batdongsan.setBdsid(bdsid);
		if (this.hopdongdatcoc == null) {
			this.hopdongdatcoc = new Hopdongdatcoc();
		}
		this.hopdongdatcoc.setDcid(dcid);
		if (this.khachhang == null) {
			this.khachhang = new Khachhang();
		}
		this.khachhang.setKhid(khid);
	}

	public int getCnid() {
		return this.cnid;
	}

	public void setCnid(int cnid) {
		this.cnid = cnid;
	}

	public float getGiatri() {
		return this.giatri;
	}

	public void setGiatri(float giatri) {
		this.giatri = giatri;
	}

	public Date getNgaylap() {
		return this.ngaylap;
	}

	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
	}

	public byte getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(byte trangthai) {
		this.trangthai = trangthai;
	}

	public Batdongsan getBatdongsan() {
		return this.batdongsan;
	}

	public void setBatdongsan(Batdongsan batdongsan) {
		this.batdongsan = batdongsan;
	}

	public Hopdongdatcoc getHopdongdatcoc() {
		return this.hopdongdatcoc;
	}

	public void setHopdongdatcoc(Hopdongdatcoc hopdongdatcoc) {
		this.hopdongdatcoc = hopdongdatcoc;
	}

	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

}