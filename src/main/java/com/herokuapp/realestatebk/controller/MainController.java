package com.herokuapp.realestatebk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.herokuapp.realestatebk.util.URL;

@RestController
public class MainController {

//	@Autowired
//	private RestOperations restOperations;

	@RequestMapping(URL.HOME)
	public String main() {
		return "This is backend of real estate manager";
	}

	@GetMapping(URL.SUCCESS)
	public boolean success() {
		return true;
	}

	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("listImage") List<MultipartFile> listImage) throws IOException {
		StringBuffer buffer = new StringBuffer();
		for (MultipartFile image : listImage) {
			buffer.append(image.getOriginalFilename()+",");
			//uploadImageToImgbb(image);
		}
		return buffer.toString();
	}

	public ResponseEntity<String> uploadImageToImgbb(MultipartFile file) {
		RestOperations restOperations = new RestTemplate();
		MultiValueMap<String, Object> paramList = new LinkedMultiValueMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		paramList.add("image", new FileSystemResource(convert(file)));
		paramList.add("key", "202ff31aa3a14568fce9ea1d7e65966b");
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(paramList,
				headers);
		ResponseEntity<String> result = restOperations.postForEntity("https://api.imgbb.com/1/upload", request,
				String.class);
		return result;
	}

	public File convert(MultipartFile file) {
		File convFile = new File(file.getOriginalFilename());
		try {
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convFile;
	}
}
