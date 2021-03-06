package com.herokuapp.realestatebk.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.herokuapp.realestatebk.entity.Batdongsan;

public class FormBatdongsan {
	private int bdsid;

	@Min(value = 1, message = "Chiều dài lớn hơn 1")
	@NotNull(message = "Thiếu chiều dài")
	private float chieudai;

	@Min(value = 1, message = "Chiều rộng lớn hơn 1")
	@NotNull(message = "Thiếu chiều rộng")
	private float chieurong;

	@NotNull(message = "Thiếu diện tích")
	private float dientich;

	@NotNull(message = "Thiếu đơn giá")
	private float dongia;

	private String hinhanh;

	@NotNull(message = "Thiếu huê hồng")
	private float huehong;

	@Size(min = 8, max = 8, message = "mã số quyền sửa dụng đất chỉ được tối đa 8 ký tự")
	private String masoqsdd;

	private String mota;

	@NotEmpty(message = "Thiếu phường")
	private String phuong;

	@NotEmpty(message = "Thiếu quận")
	private String quan;

	@NotEmpty(message = "Thiếu số nhà")
	private String sonha;

	@NotEmpty(message = "Thiếu tên đường")
	private String tenduong;

	@NotEmpty(message = "Thiếu thành phố")
	private String thanhpho;

	@NotNull(message = "Thiếu tình trạng")
	private int tinhtrang;

	@NotNull(message = "Thiếu mã khách hàng")
	private int khid;

	@NotNull(message = "Thiếu loại bất động sản")
	private int loaibdid;

	private List<FormHinhBd> formhinhBdList;

	public FormBatdongsan(Batdongsan batdongsan) {
		this.bdsid = batdongsan.getBdsid();
		this.chieudai = batdongsan.getChieudai();
		this.chieurong = batdongsan.getChieurong();
		this.dientich = batdongsan.getDientich();
		this.dongia = batdongsan.getDongia();
		this.hinhanh = batdongsan.getHinhanh();
		this.huehong = batdongsan.getHuehong();
		this.masoqsdd = batdongsan.getMasoqsdd();
		this.mota = batdongsan.getMota();
		this.phuong = batdongsan.getPhuong();
		this.quan = batdongsan.getQuan();
		this.sonha = batdongsan.getSonha();
		this.tenduong = batdongsan.getTenduong();
		this.thanhpho = batdongsan.getThanhpho();
		this.tinhtrang = batdongsan.getTinhtrang();
		this.khid = batdongsan.getKhachhang().getKhid();
		this.loaibdid = batdongsan.getLoaibd().getLoaiid();
	}

	public FormBatdongsan() {
	}

	public int getBdsid() {
		return bdsid;
	}

	public List<FormHinhBd> getFormhinhBdList() {
		return formhinhBdList;
	}

	public void setFormhinhBdList(List<FormHinhBd> formhinhBdList) {
		this.formhinhBdList = formhinhBdList;
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

	public int getKhid() {
		return khid;
	}

	public void setKhid(int khid) {
		this.khid = khid;
	}

	public int getLoaibdid() {
		return loaibdid;
	}

	public void setLoaibdid(int loaibdid) {
		this.loaibdid = loaibdid;
	}

	public Batdongsan coverToBatdongsan() {
		Batdongsan batdongsan = null;
		if (Integer.valueOf(this.bdsid) == null) {
			// use for add Batdongsan
			batdongsan = new Batdongsan(chieudai, chieurong, dientich, dongia, hinhanh, huehong, masoqsdd, mota, phuong,
					quan, sonha, tenduong, thanhpho, tinhtrang, khid, loaibdid);
		} else {
			// use for update Batdongsan
			batdongsan = new Batdongsan(bdsid, chieudai, chieurong, dientich, dongia, hinhanh, huehong, masoqsdd, mota,
					phuong, quan, sonha, tenduong, thanhpho, tinhtrang, khid, loaibdid);
		}
		return batdongsan;
	}

	public void convertToFormBatDongSan(Batdongsan batdongsan) {
		this.bdsid = batdongsan.getBdsid();
		this.chieudai = batdongsan.getChieudai();
		this.chieurong = batdongsan.getChieurong();
		this.dientich = batdongsan.getDientich();
		this.dongia = batdongsan.getDongia();
		this.hinhanh = batdongsan.getHinhanh();
		this.huehong = batdongsan.getHuehong();
		this.masoqsdd = batdongsan.getMasoqsdd();
		this.mota = batdongsan.getMota();
		this.phuong = batdongsan.getPhuong();
		this.quan = batdongsan.getQuan();
		this.sonha = batdongsan.getSonha();
		this.tenduong = batdongsan.getTenduong();
		this.thanhpho = batdongsan.getThanhpho();
		this.tinhtrang = batdongsan.getTinhtrang();
		this.khid = batdongsan.getKhachhang().getKhid();
		this.loaibdid = batdongsan.getLoaibd().getLoaiid();
	}

}
