package com.herokuapp.realestatebk.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hinhbds database table.
 * 
 */
@Entity
@Table(name="hinhbds")
@NamedQuery(name="Hinhbd.findAll", query="SELECT h FROM Hinhbd h")
public class Hinhbd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int hinhid;

	@Lob
	private String hinh;

	//bi-directional many-to-one association to Batdongsan
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bdsid")
	private Batdongsan batdongsan;

	public Hinhbd() {
	}

	public int getHinhid() {
		return this.hinhid;
	}

	public void setHinhid(int hinhid) {
		this.hinhid = hinhid;
	}

	public String getHinh() {
		return this.hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public Batdongsan getBatdongsan() {
		return this.batdongsan;
	}

	public void setBatdongsan(Batdongsan batdongsan) {
		this.batdongsan = batdongsan;
	}

}