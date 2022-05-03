package com.herokuapp.realestatebk.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.herokuapp.realestatebk.entity.Hopdongdatcoc;

public class Formhopdongdatcoc {

	private int dcid;

	@NotNull(message = "Thiếu giá trị")
	@Min(value = 1, message = "Giá trị phải lớn hơn 1")
	private float giatri;

	@NotNull(message = "Thiếu ngày hết hạn")
	@Temporal(TemporalType.DATE)
	private Date ngayhethan;

	@NotNull(message = "Thiếu ngày lập")
	@Temporal(TemporalType.DATE)
	private Date ngaylap;

	@NotNull(message = "Thiếu trạng thái")
	private byte trangthai;

	@NotNull(message = "Thiếu id bất động sản")
	private int bdsid;

	@NotNull(message = "Thiếu mã khách hàng")
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
