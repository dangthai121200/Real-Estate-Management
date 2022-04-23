package com.herokuapp.realestatebk.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the hopdongdatcoc database table.
 * 
 */
@Entity
@Table(name = "hopdongdatcoc")
public class Hopdongdatcoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int dcid;

	@Column(nullable = false)
	private float giatri;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date ngayhethan;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date ngaylap;

	@Column(nullable = true)
	@JsonIgnore
	private int tinhtrang;

	@Column(nullable = false)
	private byte trangthai;

	// bi-directional many-to-one association to Hopdongchuyennhuong
	@OneToMany(mappedBy = "hopdongdatcoc", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Hopdongchuyennhuong> hopdongchuyennhuongs;

	// bi-directional many-to-one association to Batdongsan
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bdsid")
	@JsonIgnore
	private Batdongsan batdongsan;

	// bi-directional many-to-one association to Khachhang
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "khid")
	@JsonIgnore
	private Khachhang khachhang;

	public Hopdongdatcoc() {
	}

	public Hopdongdatcoc(float giatri, Date ngayhethan, Date ngaylap, byte trangthai, int bdsid, int khid) {
		super();
		this.giatri = giatri;
		this.ngayhethan = ngayhethan;
		this.ngaylap = ngaylap;
		this.trangthai = trangthai;
		if (this.batdongsan == null) {
			this.batdongsan = new Batdongsan();
		}
		this.batdongsan.setBdsid(bdsid);
		if (this.khachhang == null) {
			this.khachhang = new Khachhang();
		}
		this.khachhang.setKhid(khid);
	}

	public Hopdongdatcoc(int dcid, float giatri, Date ngayhethan, Date ngaylap, byte trangthai, int bdsid, int khid) {
		super();
		this.dcid = dcid;
		this.giatri = giatri;
		this.ngayhethan = ngayhethan;
		this.ngaylap = ngaylap;
		this.trangthai = trangthai;
		if (this.batdongsan == null) {
			this.batdongsan = new Batdongsan();
		}
		this.batdongsan.setBdsid(bdsid);
		if (this.khachhang == null) {
			this.khachhang = new Khachhang();
		}
		this.khachhang.setKhid(khid);
	}

	public int getDcid() {
		return this.dcid;
	}

	public void setDcid(int dcid) {
		this.dcid = dcid;
	}

	public float getGiatri() {
		return this.giatri;
	}

	public void setGiatri(float giatri) {
		this.giatri = giatri;
	}

	public Date getNgayhethan() {
		return this.ngayhethan;
	}

	public void setNgayhethan(Date ngayhethan) {
		this.ngayhethan = ngayhethan;
	}

	public Date getNgaylap() {
		return this.ngaylap;
	}

	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
	}

	public int getTinhtrang() {
		return this.tinhtrang;
	}

	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public byte getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(byte trangthai) {
		this.trangthai = trangthai;
	}

	public List<Hopdongchuyennhuong> getHopdongchuyennhuongs() {
		return this.hopdongchuyennhuongs;
	}

	public void setHopdongchuyennhuongs(List<Hopdongchuyennhuong> hopdongchuyennhuongs) {
		this.hopdongchuyennhuongs = hopdongchuyennhuongs;
	}

	public Hopdongchuyennhuong addHopdongchuyennhuong(Hopdongchuyennhuong hopdongchuyennhuong) {
		getHopdongchuyennhuongs().add(hopdongchuyennhuong);
		hopdongchuyennhuong.setHopdongdatcoc(this);

		return hopdongchuyennhuong;
	}

	public Hopdongchuyennhuong removeHopdongchuyennhuong(Hopdongchuyennhuong hopdongchuyennhuong) {
		getHopdongchuyennhuongs().remove(hopdongchuyennhuong);
		hopdongchuyennhuong.setHopdongdatcoc(null);

		return hopdongchuyennhuong;
	}

	public Batdongsan getBatdongsan() {
		return this.batdongsan;
	}

	public void setBatdongsan(Batdongsan batdongsan) {
		this.batdongsan = batdongsan;
	}

	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

}