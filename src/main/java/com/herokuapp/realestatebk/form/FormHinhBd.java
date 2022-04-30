package com.herokuapp.realestatebk.form;

import com.herokuapp.realestatebk.entity.Hinhbd;

public class FormHinhBd {
	private int hinhid;
	private String hinh;
	private int bdsid;

	public FormHinhBd() {
		super();

	}

	public FormHinhBd(Hinhbd hinhbd) {
		this.hinhid = hinhbd.getHinhid();
		this.bdsid = hinhbd.getBatdongsan().getBdsid();
		this.hinh = hinhbd.getHinh();
	}

	public int getHinhid() {
		return hinhid;
	}

	public void setHinhid(int hinhid) {
		this.hinhid = hinhid;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public int getBdsid() {
		return bdsid;
	}

	public void setBdsid(int bdsid) {
		this.bdsid = bdsid;
	}

	public Hinhbd convertToHinhbd() {
		if (Integer.valueOf(this.hinhid) == null) {
			// user for add
			return new Hinhbd(this.hinh, this.bdsid);
		} else {
			// user for update
			return new Hinhbd(this.hinhid, this.hinh, this.bdsid);
		}
	}

	public void converToFormHinhBd(Hinhbd hinhbd) {
		this.hinhid = hinhbd.getHinhid();
		this.bdsid = hinhbd.getBatdongsan().getBdsid();
		this.hinh = hinhbd.getHinh();
	}

}
