package com.herokuapp.realestatebk.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.herokuapp.realestatebk.entity.Hopdongchuyennhuong;

public class FormHopdongchuyennhuong {

	private int cnid;
	@NotNull(message = "Thiếu giá trị")
	private float giatri;
	@NotNull(message = "Thiếu ngày lập")
	@Temporal(TemporalType.DATE)
	private Date ngaylap;
	@NotNull(message = "Thiếu trạng thái")
	private byte trangthai;
	@NotNull(message = "Thiếu id bắt đống sản")
	private int bdsid;
	@NotNull(message = "Thiếu mã hợp đồng đặt cọc")
	private int dcid;
	@NotNull(message = "Thiếu mã khách hang")
	private int khid;

	public FormHopdongchuyennhuong() {
	}

	public FormHopdongchuyennhuong(Hopdongchuyennhuong hopdongchuyennhuong) {
		super();
		this.cnid = hopdongchuyennhuong.getCnid();
		this.giatri = hopdongchuyennhuong.getGiatri();
		this.ngaylap = hopdongchuyennhuong.getNgaylap();
		this.trangthai = hopdongchuyennhuong.getTrangthai();
		this.bdsid = hopdongchuyennhuong.getBatdongsan().getBdsid();
		this.dcid = hopdongchuyennhuong.getHopdongdatcoc().getDcid();
		this.khid = hopdongchuyennhuong.getKhachhang().getKhid();
	}

	public int getCnid() {
		return cnid;
	}

	public void setCnid(int cnid) {
		this.cnid = cnid;
	}

	public float getGiatri() {
		return giatri;
	}

	public void setGiatri(float giatri) {
		this.giatri = giatri;
	}

	public Date getNgaylap() {
		return ngaylap;
	}

	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
	}

	public byte getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(byte trangthai) {
		this.trangthai = trangthai;
	}

	public int getBdsid() {
		return bdsid;
	}

	public void setBdsid(int bdsid) {
		this.bdsid = bdsid;
	}

	public int getDcid() {
		return dcid;
	}

	public void setDcid(int dcid) {
		this.dcid = dcid;
	}

	public int getKhid() {
		return khid;
	}

	public void setKhid(int khid) {
		this.khid = khid;
	}

	public Hopdongchuyennhuong convertToHopdongchuyennhuong() {
		if(Integer.valueOf(this.cnid) == null) {
			return new Hopdongchuyennhuong(this.giatri, this.ngaylap, this.trangthai, this.bdsid, this.dcid, this.khid);
		}else {
			return new Hopdongchuyennhuong(this.cnid, this.giatri, this.ngaylap, this.trangthai, this.bdsid, this.dcid, this.khid);
		}
	}

}
