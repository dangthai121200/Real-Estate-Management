package com.herokuapp.realestatebk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the yeucaukhachhang database table.
 * 
 */
@Entity
@Table(name = "yeucaukhachhang")
public class Yeucaukhachhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int ycid;

	@Column(nullable = false)
	private float daif;

	@Column(nullable = false)
	private float dait;

	@Column(nullable = false)
	private float dientich;

	@Column(nullable = false)
	private float giaf;

	@Column(nullable = false)
	private float giat;

	@Column(nullable = false, length = 300)
	private String mota;

	@Column(nullable = false)
	private float rongf;

	@Column(nullable = false)
	private float rongt;

	@Column(nullable = false, length = 50)
	private String vitri;

	// bi-directional many-to-one association to Khachhang
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "khid")
	@JsonIgnore
	private Khachhang khachhang;

	// bi-directional many-to-one association to Loaibd
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loaiid")
	@JsonIgnore
	private Loaibd loaibd;

	public Yeucaukhachhang() {
	}

	public int getYcid() {
		return this.ycid;
	}

	public void setYcid(int ycid) {
		this.ycid = ycid;
	}

	public float getDaif() {
		return this.daif;
	}

	public void setDaif(float daif) {
		this.daif = daif;
	}

	public float getDait() {
		return this.dait;
	}

	public void setDait(float dait) {
		this.dait = dait;
	}

	public float getDientich() {
		return this.dientich;
	}

	public void setDientich(float dientich) {
		this.dientich = dientich;
	}

	public float getGiaf() {
		return this.giaf;
	}

	public void setGiaf(float giaf) {
		this.giaf = giaf;
	}

	public float getGiat() {
		return this.giat;
	}

	public void setGiat(float giat) {
		this.giat = giat;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public float getRongf() {
		return this.rongf;
	}

	public void setRongf(float rongf) {
		this.rongf = rongf;
	}

	public float getRongt() {
		return this.rongt;
	}

	public void setRongt(float rongt) {
		this.rongt = rongt;
	}

	public String getVitri() {
		return this.vitri;
	}

	public void setVitri(String vitri) {
		this.vitri = vitri;
	}

	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public Loaibd getLoaibd() {
		return this.loaibd;
	}

	public void setLoaibd(Loaibd loaibd) {
		this.loaibd = loaibd;
	}

}