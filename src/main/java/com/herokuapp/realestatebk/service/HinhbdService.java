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

@Service
@Transactional(rollbackFor = Exception.class)
public class HinhbdService {
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

	public List<String> uploadImage(FormUploadImage formUploadImage) throws RealEsateException, JsonMappingException, JsonProcessingException {
		boolean flag = batdongsanRepository.existsById(formUploadImage.getBdsid());
		List<String> listUrlImage = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		String body = "";
		JsonNode jsonNode = null;
		String urlImage = "";
		if (flag) {
			Batdongsan batdongsan = batdongsanRepository.findById(formUploadImage.getBdsid()).get();
			// required list max is 5 and min is 1
			if (formUploadImage.getListImage().size() > 0 && formUploadImage.getListImage().size() < 5) {
				// get image first for avatar of batdongsan, name image is bdsid
				body = uploadImageToImgbb(formUploadImage.getListImage().get(0),
						String.valueOf(formUploadImage.getBdsid())).getBody();
				jsonNode = mapper.readTree(body);
				urlImage = jsonNode.get("data").get("display_url").asText();
				batdongsan.setHinhanh(urlImage);
				listUrlImage.add(urlImage);
				// set list image to hinhbatdongsan, name image is bdsid
				for (int i = 1; i < formUploadImage.getListImage().size(); i++) {
					body = uploadImageToImgbb(formUploadImage.getListImage().get(i),
							String.valueOf(formUploadImage.getBdsid())).getBody();
					jsonNode = mapper.readTree(body);
					urlImage = jsonNode.get("data").get("display_url").asText();
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

	public ResponseEntity<String> uploadImageToImgbb(MultipartFile file, String nameImage) {
		RestOperations restOperations = new RestTemplate();
		MultiValueMap<String, Object> paramList = new LinkedMultiValueMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		File coverFile = convert(file, nameImage);
		paramList.add("image", new FileSystemResource(coverFile));
		paramList.add("key", "202ff31aa3a14568fce9ea1d7e65966b");
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(paramList,
				headers);
		ResponseEntity<String> result = restOperations.postForEntity("https://api.imgbb.com/1/upload", request,
				String.class);
		if (coverFile.exists()) {
			coverFile.delete();
		}
		return result;
	}

	public File convert(MultipartFile file, String nameImage) {
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
