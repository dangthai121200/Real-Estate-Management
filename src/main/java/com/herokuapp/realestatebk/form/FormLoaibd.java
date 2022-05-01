package com.herokuapp.realestatebk.form;

import javax.validation.constraints.NotEmpty;

import com.herokuapp.realestatebk.entity.Loaibd;

public class FormLoaibd {

	private int loaiid;
	@NotEmpty(message = "Thiếu tên loại bất động sản")
	private String tenloai;

	public FormLoaibd(Loaibd loaibd) {
		super();
		this.loaiid = loaibd.getLoaiid();
		this.tenloai = loaibd.getTenloai();
	}

	public int getLoaiid() {
		return loaiid;
	}

	public void setLoaiid(int loaiid) {
		this.loaiid = loaiid;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public Loaibd convertToLoaibd() {
		if (Integer.valueOf(this.loaiid) == null) {
			// use for add
			return new Loaibd(this.tenloai);
		} else {
			// use for update
			return new Loaibd(this.loaiid, this.tenloai);
		}
	}

	public void convertToFormLoaibd(Loaibd loaibd) {
		this.loaiid = loaibd.getLoaiid();
		this.tenloai = loaibd.getTenloai();
	}

}
