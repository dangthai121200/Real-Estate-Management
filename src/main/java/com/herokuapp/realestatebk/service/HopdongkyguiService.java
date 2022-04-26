package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Hopdongkygui;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.form.FormHopDongKyGui;
import com.herokuapp.realestatebk.repository.BatdongsanRepository;
import com.herokuapp.realestatebk.repository.HopdongchuyennhhuongRepository;
import com.herokuapp.realestatebk.repository.HopdongkyguiRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class HopdongkyguiService {

	@Autowired
	private HopdongkyguiRepository hopdongkyguiRepository;
	
	@Autowired
	private BatdongsanRepository batdongsanRepository;
	
	@Autowired
	private HopdongchuyennhhuongRepository hopdongchuyennhhuongRepository;
	
	public List<FormHopDongKyGui> getAllHopdongkygui() {
		List<FormHopDongKyGui> formHopDongKyGuis = new ArrayList<>();
		List<Hopdongkygui> hopdongkyguis = (List<Hopdongkygui>) hopdongkyguiRepository.findAll();
		for (Hopdongkygui hopdongkygui : hopdongkyguis) {
			formHopDongKyGuis.add(new FormHopDongKyGui(hopdongkygui));
		}
		return formHopDongKyGuis;
	}

	public FormHopDongKyGui addHopdongkygui(FormHopDongKyGui formHopDongKyGui)  throws Exception  {
		boolean flag = batdongsanRepository.existsById(formHopDongKyGui.getBdsid());
		if(flag) {
			Hopdongkygui hopdongkygui = hopdongkyguiRepository.save(formHopDongKyGui.coverToHopdongkygui());
			FormHopDongKyGui fHopDongKyGui = new FormHopDongKyGui(hopdongkygui);
			return fHopDongKyGui;
		}else
			throw new Exception(MessageException.messBatdongsanNotFound);
		
	}

	public FormHopDongKyGui editHopdongkygui(FormHopDongKyGui formHopDongKyGui) {
		Hopdongkygui hopdongkyguiEdit = null;
		FormHopDongKyGui formHopDongKyGuiEdit = null;
		boolean flag = hopdongkyguiRepository.existsById(formHopDongKyGui.getKgid());
		if (flag) {
			hopdongkyguiEdit = hopdongkyguiRepository.save(formHopDongKyGui.coverToHopdongkygui());
			formHopDongKyGuiEdit = new FormHopDongKyGui(hopdongkyguiEdit);
		}
		return formHopDongKyGuiEdit;
	}

	public FormHopDongKyGui deleteHopdongkygui(int id) throws Exception{
		boolean flag = hopdongkyguiRepository.existsById(id);
		if (flag) {
			Hopdongkygui hopdongkygui = hopdongkyguiRepository.findById(id).get();
			if (hopdongchuyennhhuongRepository.countHopdongchuyennhuongByBdsID(hopdongkygui.getBatdongsan().getBdsid()) > 0) {
				throw new Exception(MessageException.messHopdongkyguiHasBdsInHopdongchuyennhuong);
			} else if(hopdongkygui.getNgayketthuc().after(new Date())) {
				throw new Exception(MessageException.messHopdongkyguiInProcessing);
			} else {
				hopdongkyguiRepository.deleteById(id);
				FormHopDongKyGui formHopDongKyGuiDel = new FormHopDongKyGui(hopdongkygui);
				return formHopDongKyGuiDel;
			}
		} else {
			throw new Exception(MessageException.messHopdongkyguiNotExists);
		}
	}
}
