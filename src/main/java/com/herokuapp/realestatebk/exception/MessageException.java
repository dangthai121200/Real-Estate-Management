package com.herokuapp.realestatebk.exception;

public class MessageException {
	// Nhanvien
	public static final String messCanNotDeleteNhanvienHasKhachHang = "Không thể xóa nhân viên có khách hàng";
	public static final String messNhanvienNotExists = "Nhân viên không tồn tại";
	public static final String messCannotupdateNhanvien = "Không thể cập nhật nhân viên";

	// Khachhang
	public static final String messCanNotDeleteKhachhangHasHopdongkygui = "Không thể xóa khách hàng có hợp đồng ký gửi";
	public static final String messCanNotDeleteKhachhangHasHopdongchuyennhuong = "Không thể xóa khách hàng có hợp đồng chuyển nhượng";
	public static final String messKhachhangNotExists = "Khách hàng không tồn tại";

	// Batdongan
	public static final String messBatdongsanNotFound = "Không thể tìm thấy bất động sản";
	public static final String messBatdongsanHaveHDKygui = "Bất động sản đã có hợp đồng ký gửi";
	public static final String messBatdongsanHaveHDDatcoc = "Bất động sản đã có hợp đồng đặt cọc";
	public static final String messBatdongsanHaveHDChuyennhuong = "Bất động sản đã có hợp đồng chuyển nhượng";
	public static final String messBatdongsanNotHaveHDKyGui = "Bất động sản chưa có hợp đồng ký gửi";

	// Yeucaukhachhang
	public static final String messYeucaukhachhangNotExists = "Yêu cầu khách hàng không tồn tại";
	
//	Hopdongkygui
	public static final String messHopdongkyguiHasBdsInHopdongchuyennhuong = "Bất động sản đang trong quá trình chuyển nhượng";
	public static final String messHopdongkyguiHasBdsInHopdongdatcoc = "Bất động sản đang trong quá trình đặt cọc";
	public static final String messHopdongkyguiInProcessing = "Hợp đồng ký gửi còn thời hạn";
	public static final String messHopdongkyguiNotExists = "Hợp đồng ký gửi không tồn tại";
	public static final String messHopdongkyguiExists = "Bất động sản đã có hợp đồng ký gửi";
	public static final String messDateStartHopdongkyguis = "Ngày bắt đầu không được trước ngày hiện tại";
	public static final String messDateEndHopdongkyguis = "Ngày Kết thúc phải sau ngày bắt đầu";
	
	// Hopdongchuyennhuong
	public static final String messHopdongchuyennhuongNotExists = "Hợp đồng chuyển nhượng không tồn tại";
	public static final String messHopdongchuyennhuongExists = "Bất động sản đã có hợp đồng chuyển nhượng";
	public static final String messHopdongchuyennhuongHaveNotHDDatcoc = "Bất động sản chưa có hợp đồng đặt cọc";
	public static final String messStartDateHopdongchuyennhuong = "Ngày lập phải bằng hoặc sau ngày hiện tại";

	// Hợp đồng đặt cọc
	public static final String messHopdongdatcocHaveHopdongchuyennhuong = "Hợp Đồng Đặt Cọc đang trong Hợp Đồng Chuyển Nhượng";
	public static final String messDateStartHDDatcoc = "Ngày lập không được trước ngày hiện tại";
	public static final String messDateEndHDDatcoc = "Ngày hết hạn phải sau ngày lập";
	
	//Upload image
	public static final String messNotExistsImage = "Danh sách ảnh không được rỗng";
	

}
