package com.herokuapp.realestatebk.exception;

public class MessageException {
//	Nhanvien
	public static final String messCanNotDeleteNhanvienHasKhachHang = "Không thể xóa nhân viên có khách hàng";
	public static final String messNhanvienNotExists = "Nhân viên không tồn tại";
	public static final String messCannotupdateNhanvien = "Không thể cập nhật nhân viên";
	
//	Khachhang
	public static final String messCanNotDeleteKhachhangHasHopdongkygui = "Không thể xóa khách hàng có hợp đồng ký gửi";
	public static final String messCanNotDeleteKhachhangHasHopdongchuyennhuong = "Không thể xóa khách hàng có hợp đồng chuyển nhượng";
	public static final String messKhachhangNotExists = "Khách hàng không tồn tại";
	
//	Batdongan 
	public static final String messBatdongsanNotFound = "Không thể tìm thấy bất động sản";
	
//	Yeucaukhachhang
	public static final String messYeucaukhachhangNotExists = "Yêu cầu khách hàng không tồn tại";
}
