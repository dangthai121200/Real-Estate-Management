package com.herokuapp.realestatebk.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.realestatebk.entity.Batdongsan;
import com.herokuapp.realestatebk.entity.Hopdongkygui;
import com.herokuapp.realestatebk.exception.MessageException;
import com.herokuapp.realestatebk.form.FormAddHopdongkygui;
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

	public FormAddHopdongkygui addHopdongkygui(FormAddHopdongkygui formAddHopdongkygui) throws Exception {
		Batdongsan batdongsan = batdongsanRepository.save(formAddHopdongkygui.getBatdongsan());
		formAddHopdongkygui.setBatdongsan(batdongsan);
		Hopdongkygui hopdongkygui = hopdongkyguiRepository.save(formAddHopdongkygui.coverToHopdongkygui());
		return new FormAddHopdongkygui(hopdongkygui);
	}

	public FormHopDongKyGui deleteHopdongkygui(int id) throws Exception {
		boolean flag = hopdongkyguiRepository.existsById(id);
		if (flag) {
			Hopdongkygui hopdongkygui = hopdongkyguiRepository.findById(id).get();
			if (hopdongchuyennhhuongRepository
					.countHopdongchuyennhuongByBdsID(hopdongkygui.getBatdongsan().getBdsid()) > 0) {
				throw new Exception(MessageException.messHopdongkyguiHasBdsInHopdongchuyennhuong);
			} else if (hopdongkygui.getNgayketthuc().after(new Date())) {
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

	public FormHopDongKyGui getHopdongkyguiByID(int id) throws Exception {
		boolean flag = hopdongkyguiRepository.existsById(id);
		if (flag) {
			Hopdongkygui hopdongkygui = hopdongkyguiRepository.findById(id).get();
			FormHopDongKyGui formHopDongKyGui = new FormHopDongKyGui(hopdongkygui);
			return formHopDongKyGui;
		} else 
			throw new Exception(MessageException.messHopdongkyguiNotExists);
	}

}
