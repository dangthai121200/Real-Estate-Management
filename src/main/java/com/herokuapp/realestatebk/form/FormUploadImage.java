package com.herokuapp.realestatebk.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class FormUploadImage {

	@NotNull(message = "Thiếu danh sách ảnh")
	private List<MultipartFile> listImage;
	@Min(value = 1, message = "Thiếu id của bất động sản")
	@NotNull(message = "Thiếu id của bất động sản")
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
