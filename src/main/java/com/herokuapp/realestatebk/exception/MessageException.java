package com.herokuapp.realestatebk.exception;

public class MessageException {
//	Nhanvien
	public static final String messCanNotDeleteNhanvienHasKhachHang = "Không thể xóa nhân viên có khách hàng";
	public static final String messNhanvienNotExists = "Nhân viên không tồn tại";
	
	
//	Khachhang
	public static final String messCanNotDeleteKhachhangHasHopdongkygui = "Không thể xóa khách hàng có hợp đồng ký gửi";
	public static final String messCanNotDeleteKhachhangHasHopdongchuyennhuong = "Không thể xóa khách hàng có hợp đồng chuyển nhượng";
	public static final String messKhachhangNotExists = "Khách hàng không tồn tại";
}
