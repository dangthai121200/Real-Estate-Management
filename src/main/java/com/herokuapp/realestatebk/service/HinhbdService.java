package com.herokuapp.realestatebk.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.entity.Hinhbd;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.exception.RealEsateException;
import com.herokuapp.realestatebk.form.FormHinhBd;
import com.herokuapp.realestatebk.form.FormUploadImage;
import com.herokuapp.realestatebk.repository.BatdongsanRepository;
import com.herokuapp.realestatebk.repository.HinhbdRepository;
import com.herokuapp.realestatebk.util.URL;

@Service
@Transactional(rollbackFor = Exception.class)
public class HinhbdService {
	public static final int MAX_LIST_IMAGE = 5;
	public static final int MIN_LIST_IMAGE = 1;

	@Autowired
	private HinhbdRepository hinhbdRepository;

	@Autowired
	private BatdongsanRepository batdongsanRepository;

	public List<FormHinhBd> getAllHinhbd() {
		List<FormHinhBd> formHinhBds = new ArrayList<>();
		List<Hinhbd> hinhbdsList = (List<Hinhbd>) hinhbdRepository.findAll();
		for (Hinhbd hinhbd : hinhbdsList) {
			formHinhBds.add(new FormHinhBd(hinhbd));
		}
		return formHinhBds;
	}

	public List<String> uploadImage(FormUploadImage formUploadImage)
			throws RealEsateException, JsonMappingException, JsonProcessingException {
		boolean flag = batdongsanRepository.existsById(formUploadImage.getBdsid());
		List<String> listUrlImage = new ArrayList<>();
		String body = "";
		String urlImage = "";
		if (flag) {
			// required list max is 5 and min is 1
			if (formUploadImage.getListImage().size() >= MIN_LIST_IMAGE
					&& formUploadImage.getListImage().size() <= MAX_LIST_IMAGE) {
				Batdongsan batdongsan = batdongsanRepository.findById(formUploadImage.getBdsid()).get();
				if (batdongsan.getHinhanh() == null || batdongsan.getHinhanh().isEmpty()) {
					// get image first for avatar of batdongsan, name image is bdsid
					urlImage = setAvatarForBatDongSan(batdongsan, formUploadImage.getListImage().get(0));
					listUrlImage.add(urlImage);
				}
				// set list image to hinhbatdongsan, name image is bdsid
				for (int i = 0; i < formUploadImage.getListImage().size(); i++) {
					body = uploadImageToImgbb(formUploadImage.getListImage().get(i),
							String.valueOf(formUploadImage.getBdsid())).getBody();
					urlImage = getDataFormJsonImage(body);
					hinhbdRepository.save(new Hinhbd(urlImage, formUploadImage.getBdsid()));
					listUrlImage.add(urlImage);
				}
				return listUrlImage;
			} else {
				throw new RealEsateException(MessageException.messNotExistsImage);
			}
		} else {
			throw new RealEsateException(MessageException.messBatdongsanNotFound);
		}
	}

	public String setAvatarForBatDongSan(Batdongsan batdongsan, MultipartFile image)
			throws JsonMappingException, JsonProcessingException {
		String body = uploadImageToImgbb(image, String.valueOf(batdongsan.getBdsid())).getBody();
		String urlImage = getDataFormJsonImage(body);
		batdongsan.setHinhanh(urlImage);
		return urlImage;
	}

	private String getDataFormJsonImage(String data) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(data);
		String urlImage = jsonNode.get("data").get("display_url").asText();
		return urlImage;
	}

	private ResponseEntity<String> uploadImageToImgbb(MultipartFile file, String nameImage) {
		RestOperations restOperations = new RestTemplate();
		MultiValueMap<String, Object> paramList = new LinkedMultiValueMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		File coverFile = convert(file, nameImage);
		paramList.add(URL.PARAM_IMAGE, new FileSystemResource(coverFile));
		paramList.add(URL.PARAM_KEY, URL.KEY_UPLOAD_IMAGE);
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(paramList,
				headers);
		ResponseEntity<String> result = restOperations.postForEntity(URL.API_UPLOAD_IMAGE, request, String.class);
		if (coverFile.exists()) {
			coverFile.delete();
		}
		return result;
	}

	private File convert(MultipartFile file, String nameImage) {
		File convFile = new File(nameImage);
		try {
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return convFile;
	}
}
