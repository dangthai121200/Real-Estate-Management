package com.herokuapp.realestatebk.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the batdongsan database table.
 * 
 */
@Entity
@Table(name = "batdongsan")
public class Batdongsan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int bdsid;

	@Column(nullable = false)
	private float chieudai;

	@Column(nullable = false)
	private float chieurong;

	@Column(nullable = false)
	private float dientich;

	@Column(nullable = false)
	private float dongia;

	@Lob
	private String hinhanh;

	@Column(nullable = false)
	private float huehong;

	@Column(length = 8)
	private String masoqsdd;

	@Column(length = 200)
	private String mota;

	@Column(nullable = false, length = 50)
	private String phuong;

	@Column(nullable = false, length = 50)
	private String quan;

	@Column(nullable = false, length = 50)
	private String sonha;

	@Column(nullable = false, length = 50)
	private String tenduong;

	@Column(nullable = false, length = 50)
	private String thanhpho;

	@Column(nullable = false)
	private int tinhtrang;

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

	// bi-directional many-to-one association to Hinhbd
	@OneToMany(mappedBy = "batdongsan", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Hinhbd> hinhbds;

	// bi-directional many-to-one association to Hopdongchuyennhuong
	@OneToMany(mappedBy = "batdongsan", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Hopdongchuyennhuong> hopdongchuyennhuongs;

	// bi-directional many-to-one association to Hopdongdatcoc
	@OneToMany(mappedBy = "batdongsan", fetch = FetchType.LAZY)
	@JsonIgnore
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Hopdongdatcoc> hopdongdatcocs;

	// bi-directional many-to-one association to Hopdongkygui
	@OneToMany(mappedBy = "batdongsan", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Hopdongkygui> hopdongkyguis;

	public Batdongsan() {
	}

	public Batdongsan(int bdsid, float chieudai, float chieurong, float dientich, float dongia, String hinhanh,
			float huehong, String masoqsdd, String mota, String phuong, String quan, String sonha, String tenduong,
			String thanhpho, int tinhtrang, int khid, int loaibdid) {
		super();
		this.bdsid = bdsid;
		this.chieudai = chieudai;
		this.chieurong = chieurong;
		this.dientich = dientich;
		this.dongia = dongia;
		this.hinhanh = hinhanh;
		this.huehong = huehong;
		this.masoqsdd = masoqsdd;
		this.mota = mota;
		this.phuong = phuong;
		this.quan = quan;
		this.sonha = sonha;
		this.tenduong = tenduong;
		this.thanhpho = thanhpho;
		this.tinhtrang = tinhtrang;
		if (this.khachhang == null) {
			this.khachhang = new Khachhang();
		}
		this.khachhang.setKhid(khid);
		if (this.loaibd == null) {
			this.loaibd = new Loaibd();
		}
		this.loaibd.setLoaiid(loaibdid);
	}

	public Batdongsan(float chieudai, float chieurong, float dientich, float dongia, String hinhanh, float huehong,
			String masoqsdd, String mota, String phuong, String quan, String sonha, String tenduong, String thanhpho,
			int tinhtrang, int khid, int loaibdid) {
		super();
		this.chieudai = chieudai;
		this.chieurong = chieurong;
		this.dientich = dientich;
		this.dongia = dongia;
		this.hinhanh = hinhanh;
		this.huehong = huehong;
		this.masoqsdd = masoqsdd;
		this.mota = mota;
		this.phuong = phuong;
		this.quan = quan;
		this.sonha = sonha;
		this.tenduong = tenduong;
		this.thanhpho = thanhpho;
		this.tinhtrang = tinhtrang;
		if (this.khachhang == null) {
			this.khachhang = new Khachhang();
		}
		this.khachhang.setKhid(khid);
		if (this.loaibd == null) {
			this.loaibd = new Loaibd();
		}
		this.loaibd.setLoaiid(loaibdid);
	}

	public int getBdsid() {
		return this.bdsid;
	}

	public void setBdsid(int bdsid) {
		this.bdsid = bdsid;
	}

	public float getChieudai() {
		return this.chieudai;
	}

	public void setChieudai(float chieudai) {
		this.chieudai = chieudai;
	}

	public float getChieurong() {
		return this.chieurong;
	}

	public void setChieurong(float chieurong) {
		this.chieurong = chieurong;
	}

	public float getDientich() {
		return this.dientich;
	}

	public void setDientich(float dientich) {
		this.dientich = dientich;
	}

	public float getDongia() {
		return this.dongia;
	}

	public void setDongia(float dongia) {
		this.dongia = dongia;
	}

	public String getHinhanh() {
		return this.hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public float getHuehong() {
		return this.huehong;
	}

	public void setHuehong(float huehong) {
		this.huehong = huehong;
	}

	public String getMasoqsdd() {
		return this.masoqsdd;
	}

	public void setMasoqsdd(String masoqsdd) {
		this.masoqsdd = masoqsdd;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getPhuong() {
		return this.phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getQuan() {
		return this.quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getSonha() {
		return this.sonha;
	}

	public void setSonha(String sonha) {
		this.sonha = sonha;
	}

	public String getTenduong() {
		return this.tenduong;
	}

	public void setTenduong(String tenduong) {
		this.tenduong = tenduong;
	}

	public String getThanhpho() {
		return this.thanhpho;
	}

	public void setThanhpho(String thanhpho) {
		this.thanhpho = thanhpho;
	}

	public int getTinhtrang() {
		return this.tinhtrang;
	}

	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
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

	public List<Hinhbd> getHinhbds() {
		return this.hinhbds;
	}

	public void setHinhbds(List<Hinhbd> hinhbds) {
		this.hinhbds = hinhbds;
	}

	public Hinhbd addHinhbd(Hinhbd hinhbd) {
		getHinhbds().add(hinhbd);
		hinhbd.setBatdongsan(this);

		return hinhbd;
	}

	public Hinhbd removeHinhbd(Hinhbd hinhbd) {
		getHinhbds().remove(hinhbd);
		hinhbd.setBatdongsan(null);

		return hinhbd;
	}

	public List<Hopdongchuyennhuong> getHopdongchuyennhuongs() {
		return this.hopdongchuyennhuongs;
	}

	public void setHopdongchuyennhuongs(List<Hopdongchuyennhuong> hopdongchuyennhuongs) {
		this.hopdongchuyennhuongs = hopdongchuyennhuongs;
	}

	public Hopdongchuyennhuong addHopdongchuyennhuong(Hopdongchuyennhuong hopdongchuyennhuong) {
		getHopdongchuyennhuongs().add(hopdongchuyennhuong);
		hopdongchuyennhuong.setBatdongsan(this);

		return hopdongchuyennhuong;
	}

	public Hopdongchuyennhuong removeHopdongchuyennhuong(Hopdongchuyennhuong hopdongchuyennhuong) {
		getHopdongchuyennhuongs().remove(hopdongchuyennhuong);
		hopdongchuyennhuong.setBatdongsan(null);

		return hopdongchuyennhuong;
	}

	public List<Hopdongdatcoc> getHopdongdatcocs() {
		return this.hopdongdatcocs;
	}

	public void setHopdongdatcocs(List<Hopdongdatcoc> hopdongdatcocs) {
		this.hopdongdatcocs = hopdongdatcocs;
	}

	public Hopdongdatcoc addHopdongdatcoc(Hopdongdatcoc hopdongdatcoc) {
		getHopdongdatcocs().add(hopdongdatcoc);
		hopdongdatcoc.setBatdongsan(this);

		return hopdongdatcoc;
	}

	public Hopdongdatcoc removeHopdongdatcoc(Hopdongdatcoc hopdongdatcoc) {
		getHopdongdatcocs().remove(hopdongdatcoc);
		hopdongdatcoc.setBatdongsan(null);

		return hopdongdatcoc;
	}

	public List<Hopdongkygui> getHopdongkyguis() {
		return this.hopdongkyguis;
	}

	public void setHopdongkyguis(List<Hopdongkygui> hopdongkyguis) {
		this.hopdongkyguis = hopdongkyguis;
	}

	public Hopdongkygui addHopdongkygui(Hopdongkygui hopdongkygui) {
		getHopdongkyguis().add(hopdongkygui);
		hopdongkygui.setBatdongsan(this);

		return hopdongkygui;
	}

	public Hopdongkygui removeHopdongkygui(Hopdongkygui hopdongkygui) {
		getHopdongkyguis().remove(hopdongkygui);
		hopdongkygui.setBatdongsan(null);

		return hopdongkygui;
	}

}