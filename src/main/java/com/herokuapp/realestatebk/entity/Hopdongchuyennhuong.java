package com.herokuapp.realestatebk.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hopdongchuyennhuong database table.
 * 
 */
@Entity
@Table(name="hopdongchuyennhuong")
@NamedQuery(name="Hopdongchuyennhuong.findAll", query="SELECT h FROM Hopdongchuyennhuong h")
public class Hopdongchuyennhuong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int cnid;

	@Column(nullable=false)
	private float giatri;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date ngaylap;

	@Column(nullable=false)
	private byte trangthai;

	//bi-directional many-to-one association to Batdongsan
	@ManyToOne
	@JoinColumn(name="bdsid")
	private Batdongsan batdongsan;

	//bi-directional many-to-one association to Hopdongdatcoc
	@ManyToOne
	@JoinColumn(name="dcid")
	private Hopdongdatcoc hopdongdatcoc;

	//bi-directional many-to-one association to Khachhang
	@ManyToOne
	@JoinColumn(name="khid")
	private Khachhang khachhang;

	public Hopdongchuyennhuong() {
	}

	public int getCnid() {
		return this.cnid;
	}

	public void setCnid(int cnid) {
		this.cnid = cnid;
	}

	public float getGiatri() {
		return this.giatri;
	}

	public void setGiatri(float giatri) {
		this.giatri = giatri;
	}

	public Date getNgaylap() {
		return this.ngaylap;
	}

	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
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

	public Hopdongdatcoc getHopdongdatcoc() {
		return this.hopdongdatcoc;
	}

	public void setHopdongdatcoc(Hopdongdatcoc hopdongdatcoc) {
		this.hopdongdatcoc = hopdongdatcoc;
	}

	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

}