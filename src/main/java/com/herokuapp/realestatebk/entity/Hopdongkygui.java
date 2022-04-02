package com.herokuapp.realestatebk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hopdongkygui database table.
 * 
 */
@Entity
@Table(name="hopdongkygui")
@NamedQuery(name="Hopdongkygui.findAll", query="SELECT h FROM Hopdongkygui h")
public class Hopdongkygui implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int kgid;

	@Column(nullable=false)
	private float chiphidv;

	@Column(nullable=false)
	private float giatri;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date ngaybd;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date ngayketthuc;

	@Column(nullable=false)
	private byte trangthai;

	//bi-directional many-to-one association to Batdongsan
	@ManyToOne
	@JoinColumn(name="bdsid")
	private Batdongsan batdongsan;

	//bi-directional many-to-one association to Khachhang
	@ManyToOne
	@JoinColumn(name="khid")
	private Khachhang khachhang;

	public Hopdongkygui() {
	}

	public int getKgid() {
		return this.kgid;
	}

	public void setKgid(int kgid) {
		this.kgid = kgid;
	}

	public float getChiphidv() {
		return this.chiphidv;
	}

	public void setChiphidv(float chiphidv) {
		this.chiphidv = chiphidv;
	}

	public float getGiatri() {
		return this.giatri;
	}

	public void setGiatri(float giatri) {
		this.giatri = giatri;
	}

	public Date getNgaybd() {
		return this.ngaybd;
	}

	public void setNgaybd(Date ngaybd) {
		this.ngaybd = ngaybd;
	}

	public Date getNgayketthuc() {
		return this.ngayketthuc;
	}

	public void setNgayketthuc(Date ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}

	public byte getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(byte trangthai) {
		this.trangthai = trangthai;
	}

	public Batdongsan getBatdongsan() {
		return this.batdongsan;
	}

	public void setBatdongsan(Batdongsan batdongsan) {
		this.batdongsan = batdongsan;
	}

	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

}