package com.herokuapp.realestatebk.form;

import java.util.Date;

import com.herokuapp.realestatebk.entity.Hopdongdatcoc;

public class Formhopdongdatcoc {

	private int dcid;

	private float giatri;

	private Date ngayhethan;

	private Date ngaylap;

	private byte trangthai;

	// private List<Hopdongchuyennhuong> hopdongchuyennhuongs;

	private int bdsid;

	private int khid;

	public Formhopdongdatcoc() {
	}

	public Formhopdongdatcoc(Hopdongdatcoc hopdongdatcoc) {
		super();
		this.dcid = hopdongdatcoc.getDcid();
		this.giatri = hopdongdatcoc.getGiatri();
		this.ngayhethan = hopdongdatcoc.getNgayhethan();
		this.ngaylap = hopdongdatcoc.getNgaylap();
		this.trangthai = hopdongdatcoc.getTrangthai();
		this.bdsid = hopdongdatcoc.getBatdongsan().getBdsid();
		this.khid = hopdongdatcoc.getKhachhang().getKhid();
	}

	public int getDcid() {
		return dcid;
	}

	public void setDcid(int dcid) {
		this.dcid = dcid;
	}

	public float getGiatri() {
		return giatri;
	}

	public void setGiatri(float giatri) {
		this.giatri = giatri;
	}

	public Date getNgayhethan() {
		return ngayhethan;
	}

	public void setNgayhethan(Date ngayhethan) {
		this.ngayhethan = ngayhethan;
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

	public int getKhid() {
		return khid;
	}

	public void setKhid(int khid) {
		this.khid = khid;
	}

	public Hopdongdatcoc convertToHopdongdatcoc() {
		if (Integer.valueOf(this.dcid) == null) {
			// use for add hopdongdatcoc
			return new Hopdongdatcoc(this.giatri, this.ngayhethan, this.ngaylap, this.trangthai, this.bdsid, this.khid);
		} else {
			// use for update hopdongdatcoc
			return new Hopdongdatcoc(this.dcid, this.giatri, this.ngayhethan, this.ngaylap, this.trangthai, this.bdsid,
					this.khid);
		}
	}

	public void convertToFormHopdongdatcoc(Hopdongdatcoc hopdongdatcoc) {
		this.dcid = hopdongdatcoc.getDcid();
		this.giatri = hopdongdatcoc.getGiatri();
		this.ngayhethan = hopdongdatcoc.getNgayhethan();
		this.ngaylap = hopdongdatcoc.getNgaylap();
		this.trangthai = hopdongdatcoc.getTrangthai();
		this.bdsid = hopdongdatcoc.getBatdongsan().getBdsid();
		this.khid = hopdongdatcoc.getKhachhang().getKhid();
	}

}