package com.herokuapp.realestatebk.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.entity.Hopdongkygui;

public class FormAddHopdongkygui {
	private int kgid;
	@NotNull(message = "Thiếu chi phí dịch vụ")
	@Min(value = 1, message = "Thiếu chi phí dịch vụ")
	private float chiphidv;
	@NotNull(message = "Thiếu giá trị")
	@Min(value = 1, message = "giá trị lớn hơn 1")
	private float giatri;
	@NotNull(message = "Thiếu Ngày bắt đầu")
	@Temporal(TemporalType.DATE)
	private Date ngaybd;
	@NotNull(message = "Thiếu ngày kết thúc")
	@Temporal(TemporalType.DATE)
	private Date ngayketthuc;
	@NotNull(message = "Thiếu trang thái")
	private byte trangthai;
	@NotNull(message = "Thiếu mã khách hàng")
	private int khid;
	@NotNull(message = "Thiếu thông tin bất động sản")
	@Valid
	private FormBatdongsan formBatdongsan;

	public FormAddHopdongkygui() {
	}

	public FormAddHopdongkygui(Hopdongkygui hopdongkygui, Batdongsan batdongsan) {
		this.kgid = hopdongkygui.getKgid();
		this.chiphidv = hopdongkygui.getChiphidv();
		this.giatri = hopdongkygui.getGiatri();
		this.ngaybd = hopdongkygui.getNgaybd();
		this.ngayketthuc = hopdongkygui.getNgayketthuc();
		this.trangthai = hopdongkygui.getTrangthai();
		this.formBatdongsan = new FormBatdongsan(batdongsan);
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

	public FormBatdongsan getFormBatdongsan() {
		return formBatdongsan;
	}

	public void setFormBatdongsan(FormBatdongsan formBatdongsan) {
		this.formBatdongsan = formBatdongsan;
	}

	public int getKhid() {
		return khid;
	}

	public void setKhid(int khid) {
		this.khid = khid;
	}

	public Hopdongkygui coverToHopdongkygui() {
		Hopdongkygui hopdongkygui = new Hopdongkygui(chiphidv, giatri, ngaybd, ngayketthuc, trangthai,
				formBatdongsan.getBdsid(), khid);
		return hopdongkygui;
	}
}
