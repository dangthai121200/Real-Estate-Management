package com.herokuapp.realestatebk.form;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.entity.Khachhang;
import com.herokuapp.realestatebk.entity.Loaibd;

public class FormBatdongsan {
	private int bdsid;
	private float chieudai;
	private float chieurong;
	private float dientich;
	private float dongia;
	private String hinhanh;
	private float huehong;
	private String masoqsdd;
	private String mota;
	private String phuong;
	private String quan;
	private String sonha;
	private String tenduong;
	private String thanhpho;
	private int tinhtrang;
	private int khachhang;
	private int loaibd;

	public FormBatdongsan(float chieudai, float chieurong, float dientich, float dongia, String hinhanh, float huehong,
			String masoqsdd, String mota, String phuong, String quan, String sonha, String tenduong, String thanhpho,
			int tinhtrang, int khachhang, int loaibd) {
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
		this.khachhang = khachhang;
		this.loaibd = loaibd;
	}

	public int getBdsid() {
		return bdsid;
	}

	public void setBdsid(int bdsid) {
		this.bdsid = bdsid;
	}

	public float getChieudai() {
		return chieudai;
	}

	public void setChieudai(float chieudai) {
		this.chieudai = chieudai;
	}

	public float getChieurong() {
		return chieurong;
	}

	public void setChieurong(float chieurong) {
		this.chieurong = chieurong;
	}

	public float getDientich() {
		return dientich;
	}

	public void setDientich(float dientich) {
		this.dientich = dientich;
	}

	public float getDongia() {
		return dongia;
	}

	public void setDongia(float dongia) {
		this.dongia = dongia;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public float getHuehong() {
		return huehong;
	}

	public void setHuehong(float huehong) {
		this.huehong = huehong;
	}

	public String getMasoqsdd() {
		return masoqsdd;
	}

	public void setMasoqsdd(String masoqsdd) {
		this.masoqsdd = masoqsdd;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getSonha() {
		return sonha;
	}

	public void setSonha(String sonha) {
		this.sonha = sonha;
	}

	public String getTenduong() {
		return tenduong;
	}

	public void setTenduong(String tenduong) {
		this.tenduong = tenduong;
	}

	public String getThanhpho() {
		return thanhpho;
	}

	public void setThanhpho(String thanhpho) {
		this.thanhpho = thanhpho;
	}

	public int getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public int getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(int khachhang) {
		this.khachhang = khachhang;
	}

	public int getLoaibd() {
		return loaibd;
	}

	public void setLoaibd(int loaibd) {
		this.loaibd = loaibd;
	}

	public Batdongsan coverToBatdongsan(Loaibd loaibds, Khachhang khachHang) {
		Batdongsan batdongsan = null;
		if (Integer.valueOf(this.bdsid) == null) {
			// use for add Batdongsan
			batdongsan = new Batdongsan(chieudai, chieurong, dientich, dongia, hinhanh, huehong, masoqsdd, mota, phuong,
					quan, sonha, tenduong, thanhpho, tinhtrang, khachHang, loaibds);
		} else {
			// use for update Batdongsan
			batdongsan = new Batdongsan(bdsid, chieudai, chieurong, dientich, dongia, hinhanh, huehong, masoqsdd, mota,
					phuong, quan, sonha, tenduong, thanhpho, tinhtrang, khachHang, loaibds);
		}
		return batdongsan;
	}

}
