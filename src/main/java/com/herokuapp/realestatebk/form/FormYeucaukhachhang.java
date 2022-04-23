package com.herokuapp.realestatebk.form;

import com.herokuapp.realestatebk.entity.Khachhang;
import com.herokuapp.realestatebk.entity.Loaibd;
import com.herokuapp.realestatebk.entity.Yeucaukhachhang;

public class FormYeucaukhachhang {
	private int ycid;
	private float daif;
	private float dait;
	private float dientich;
	private float giaf;
	private float giat;
	private String mota;
	private float rongf;
	private float rongt;
	private String vitri;
	private int khachhang;
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
	
	public Yeucaukhachhang coverToYeucaukhachhang(Khachhang khachhang, Loaibd loaibd) {
		Yeucaukhachhang yeucaukhachhang = null;
		if (Integer.valueOf(this.ycid) == null) {
			// use for add Yeucaukhachhang
			yeucaukhachhang = new Yeucaukhachhang(daif,dait,dientich,giaf,giat,mota,rongf,rongt,vitri,khachhang,loaibd);
		} else {
			// use for update Yeucaukhachhang
			yeucaukhachhang = new Yeucaukhachhang(ycid,daif,dait,dientich,giaf,giat,mota,rongf,rongt,vitri,khachhang,loaibd);
		}
		return yeucaukhachhang;
	}
	
	
}
