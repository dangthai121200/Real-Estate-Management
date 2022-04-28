package com.herokuapp.realestatebk.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.entity.Hopdongkygui;

public class FormAddHopdongkygui {
	private int kgid;
	private float chiphidv;
	private float giatri;
	@Temporal(TemporalType.DATE)
	private Date ngaybd;
	@Temporal(TemporalType.DATE)
	private Date ngayketthuc;
	private byte trangthai;
	private Batdongsan batdongsan;
	private int khid;

	public FormAddHopdongkygui() {
	}

	public FormAddHopdongkygui(Hopdongkygui hopdongkygui) {
		this.kgid = hopdongkygui.getKgid();
		this.chiphidv = hopdongkygui.getChiphidv();
		this.giatri = hopdongkygui.getGiatri();
		this.ngaybd = hopdongkygui.getNgaybd();
		this.ngayketthuc = hopdongkygui.getNgayketthuc();
		this.trangthai = hopdongkygui.getTrangthai();
		this.batdongsan = hopdongkygui.getBatdongsan();
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

	public Batdongsan getBatdongsan() {
		return batdongsan;
	}

	public void setBatdongsan(Batdongsan batdongsan) {
		this.batdongsan = batdongsan;
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
			hopdongkygui = new Hopdongkygui(chiphidv,giatri,ngaybd,ngayketthuc,trangthai,batdongsan.getBdsid(),khid);
		} else {
			// use for update Hopdongkygui
			hopdongkygui = new Hopdongkygui(kgid,chiphidv,giatri,ngaybd,ngayketthuc,trangthai,batdongsan.getBdsid(),khid);
		}
		return hopdongkygui;
	}
}
