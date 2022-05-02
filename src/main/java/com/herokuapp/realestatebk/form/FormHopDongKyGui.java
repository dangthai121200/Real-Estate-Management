package com.herokuapp.realestatebk.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.herokuapp.realestatebk.entity.Hopdongkygui;

public class FormHopDongKyGui {

	private int kgid;

	@NotNull(message = "Thiếu chi phí dịch vụ")
	@Min(value = 1, message = "Thiếu chi phí dịch vụ")
	private float chiphidv;

	@NotNull(message = "Thiếu giá trị")
	@Min(value = 1, message = "Giá trị phải lớn hơn 1")
	private float giatri;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "Thiếu ngày bắt đầu")
	private Date ngaybd;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "Thiếu ngày kết thúc")
	private Date ngayketthuc;

	@NotNull(message = "Thiếu trạng thái")
	private byte trangthai;
	@NotNull(message = "Thiếu bất động sản")
	private int bdsid;

	@NotNull(message = "Thiếu khách hàng")
	private int khid;

	public FormHopDongKyGui() {
	}

	public FormHopDongKyGui(Hopdongkygui hopdongkygui) {
		this.kgid = hopdongkygui.getKgid();
		this.chiphidv = hopdongkygui.getChiphidv();
		this.giatri = hopdongkygui.getGiatri();
		this.ngaybd = hopdongkygui.getNgaybd();
		this.ngayketthuc = hopdongkygui.getNgayketthuc();
		this.trangthai = hopdongkygui.getTrangthai();
		this.bdsid = hopdongkygui.getBatdongsan().getBdsid();
		this.khid = hopdongkygui.getKhachhang().getKhid();
	}

	public int getKgid() {
		return kgid;
	}

	public void setKgid(int kgid) {
		this.kgid = kgid;
	}

	public float getChiphidv() {
		return chiphidv;
	}

	public void setChiphidv(float chiphidv) {
		this.chiphidv = chiphidv;
	}

	public float getGiatri() {
		return giatri;
	}

	public void setGiatri(float giatri) {
		this.giatri = giatri;
	}

	public Date getNgaybd() {
		return ngaybd;
	}

	public void setNgaybd(Date ngaybd) {
		this.ngaybd = ngaybd;
	}

	public Date getNgayketthuc() {
		return ngayketthuc;
	}

	public void setNgayketthuc(Date ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
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

	public Hopdongkygui coverToHopdongkygui() {
		Hopdongkygui hopdongkygui = null;
		if (Integer.valueOf(this.kgid) == null) {
			// use for add Hopdongkygui
			hopdongkygui = new Hopdongkygui(chiphidv, giatri, ngaybd, ngayketthuc, trangthai, bdsid, khid);
		} else {
			// use for update Hopdongkygui
			hopdongkygui = new Hopdongkygui(kgid, chiphidv, giatri, ngaybd, ngayketthuc, trangthai, bdsid, khid);
		}
		return hopdongkygui;
	}
}
