package com.herokuapp.realestatebk.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FormUploadImage {
	private List<MultipartFile> listImage;
	private int bdsid;

	public FormUploadImage() {
		super();

	}

	public List<MultipartFile> getListImage() {
		return listImage;
	}

	public void setListImage(List<MultipartFile> listImage) {
		this.listImage = listImage;
	}

	public int getBdsid() {
		return bdsid;
	}

	public void setBdsid(int bdsid) {
		this.bdsid = bdsid;
	}

}
