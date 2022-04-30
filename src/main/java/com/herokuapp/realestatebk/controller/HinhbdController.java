package com.herokuapp.realestatebk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.form.FormHinhBd;
import com.herokuapp.realestatebk.form.FormUploadImage;
import com.herokuapp.realestatebk.service.HinhbdService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class HinhbdController {
	@Autowired
	private HinhbdService hinhbdService;

	@GetMapping(URL.GET_ALL_Hinhbd)
	public List<FormHinhBd> getAllHinhbd() {
		return hinhbdService.getAllHinhbd();
	}

	@PostMapping(value = URL.ADD_IMAGE_MULTI, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<String> uploadImage(FormUploadImage formUploadImage) throws Exception {
		return hinhbdService.uploadImage(formUploadImage);
	}
}
