package com.herokuapp.realestatebk.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.herokuapp.realestatebk.entity.Yeucaukhachhang;

public class FormYeucaukhachhang {
	private int ycid;
	@NotNull(message = "Thiếu chiều dài từ ")
	@Min(value = 1, message = "Chiều dài từ phải lớn hơn 1")
	private float daif;
	@NotNull(message = "Thiếu chiều dài đến ")
	@Min(value = 1, message = "Chiều dài đến phải lớn hơn 1")
	private float dait;
	@NotNull(message = "Thiếu diện tích")
	@Min(value = 1, message = "thiếu diện tích")
	private float dientich;
	@Min(value = 1, message = "Giá trị từ phải lớn hơn 1")
	@NotNull(message = "Thiếu giá trị từ")
	private float giaf;
	@Min(value = 1, message = "Giá trị đến phải lớn hơn 1")
	@NotNull(message = "Thiếu giá trị đến")
	private float giat;
	private String mota;
	@Min(value = 1, message = "Chiều rộng từ phải lớn hơn 1")
	@NotNull(message = "Thiếu chiều rộng từ")
	private float rongf;
	@Min(value = 1, message = "chiều rộng đến phải lớn hơn 1")
	@NotNull(message = "Thiếu chiều rộng đến")
	private float rongt;
	@NotEmpty(message = "Thiếu vị trí")
	private String vitri;
	@NotNull(message = "Thiếu khách hàng")
	private int khachhang;
	@NotNull(message = "Thiếu loại bất động sản")
	private int loaibd;

	public FormYeucaukhachhang() {
		super();
	}

	public FormYeucaukhachhang(int ycid, float daif, float dait, float dientich, float giaf, float giat, String mota,
			float rongf, float rongt, String vitri, int khachhang, int loaibd) {
		super();
		this.ycid = ycid;
		this.daif = daif;
		this.dait = dait;
		this.dientich = dientich;
		this.giaf = giaf;
		this.giat = giat;
		this.mota = mota;
		this.rongf = rongf;
		this.rongt = rongt;
		this.vitri = vitri;
		this.khachhang = khachhang;
		this.loaibd = loaibd;
	}

	public FormYeucaukhachhang(Yeucaukhachhang yeucaukhachhang) {
		super();
		this.ycid = yeucaukhachhang.getYcid();
		this.daif = yeucaukhachhang.getDaif();
		this.dait = yeucaukhachhang.getDait();
		this.dientich = yeucaukhachhang.getDientich();
		this.giaf = yeucaukhachhang.getGiaf();
		this.giat = yeucaukhachhang.getGiat();
		this.mota = yeucaukhachhang.getMota();
		this.rongf = yeucaukhachhang.getRongf();
		this.rongt = yeucaukhachhang.getRongt();
		this.vitri = yeucaukhachhang.getVitri();
		this.khachhang = yeucaukhachhang.getKhachhang().getKhid();
		this.loaibd = yeucaukhachhang.getLoaibd().getLoaiid();
	}

	public int getYcid() {
		return ycid;
	}

	public void setYcid(int ycid) {
		this.ycid = ycid;
	}

	public float getDaif() {
		return daif;
	}

	public void setDaif(float daif) {
		this.daif = daif;
	}

	public float getDait() {
		return dait;
	}

	public void setDait(float dait) {
		this.dait = dait;
	}

	public float getDientich() {
		return dientich;
	}

	public void setDientich(float dientich) {
		this.dientich = dientich;
	}

	public float getGiaf() {
		return giaf;
	}

	public void setGiaf(float giaf) {
		this.giaf = giaf;
	}

	public float getGiat() {
		return giat;
	}

	public void setGiat(float giat) {
		this.giat = giat;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public float getRongf() {
		return rongf;
	}

	public void setRongf(float rongf) {
		this.rongf = rongf;
	}

	public float getRongt() {
		return rongt;
	}

	public void setRongt(float rongt) {
		this.rongt = rongt;
	}

	public String getVitri() {
		return vitri;
	}

	public void setVitri(String vitri) {
		this.vitri = vitri;
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

	public Yeucaukhachhang coverToYeucaukhachhang() {
		Yeucaukhachhang yeucaukhachhang = null;
		if (Integer.valueOf(this.ycid) == null) {
			// use for add Yeucaukhachhang
			yeucaukhachhang = new Yeucaukhachhang(daif, dait, dientich, giaf, giat, mota, rongf, rongt, vitri,
					khachhang, loaibd);
		} else {
			// use for update Yeucaukhachhang
			yeucaukhachhang = new Yeucaukhachhang(ycid, daif, dait, dientich, giaf, giat, mota, rongf, rongt, vitri,
					khachhang, loaibd);
		}
		return yeucaukhachhang;
	}

}
