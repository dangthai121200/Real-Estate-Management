package com.herokuapp.realestatebk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.realestatebk.form.FormAddHopdongkygui;
import com.herokuapp.realestatebk.form.FormHopDongKyGui;
import com.herokuapp.realestatebk.service.HopdongkyguiService;
import com.herokuapp.realestatebk.util.URL;

@RestController
public class HopdongkyguiController {
	@Autowired
	private HopdongkyguiService hopdongkyguiService;

	@GetMapping(URL.GET_ALL_Hopdongkygui)
	public List<FormHopDongKyGui> getAllHopdongkygui() {
		return hopdongkyguiService.getAllHopdongkygui();
	}

	@PostMapping(URL.ADD_Hopdongkygui)
	public FormAddHopdongkygui addHopdongkygui(@RequestBody @Valid FormAddHopdongkygui formAddHopdongkygui) throws Exception {
		return hopdongkyguiService.addHopdongkygui(formAddHopdongkygui);
	}

	@DeleteMapping(URL.DELETE_Hopdongkygui)
	public FormHopDongKyGui deleteHopdongkygui(@PathVariable int id) throws Exception {
		return hopdongkyguiService.deleteHopdongkygui(id);
	}
	
	@GetMapping(URL.GET_Hopdongkygui_BY_ID)
	public FormHopDongKyGui getHopdongkyguiByID(@PathVariable int id) throws Exception {
		return hopdongkyguiService.getHopdongkyguiByID(id);
	}
}