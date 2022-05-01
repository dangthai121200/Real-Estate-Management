package com.herokuapp.realestatebk.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.herokuapp.realestatebk.util.UniqueDatabase;

@ControllerAdvice
public class HandleException {

	@ExceptionHandler(RealEsateException.class)
	public ResponseEntity<String> handleRealEsateException(Exception ex) {
		ex.printStackTrace();
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<String> SQLIntegrityConstraintViolationException(
			SQLIntegrityConstraintViolationException ex) {
		ex.printStackTrace();
		String message = "";
		if (ex.getMessage().contains(UniqueDatabase.cmnd_UNIQUE)) {
			message = "Chứng minh nhân dân đã tồn tại";
		} else if (ex.getMessage().contains(UniqueDatabase.sodienthoai_UNIQUE)) {
			message = "Số điện thoại đã tồn tại";
		} else if (ex.getMessage().contains(UniqueDatabase.masoqsdd_UNIQUE)) {
			message = "Quyền sử dụng đất đã tồn tại đã tồn tại";
		} else if (ex.getMessage().contains(UniqueDatabase.taikhoan_UNIQUE)) {
			message = "Username đã tồn tại đã tồn tại";
		} else if (ex.getMessage().contains(UniqueDatabase.email_UNIQUE)) {
			message = "Email đã tồn tại đã tồn tại";
		} else {
			message = "Có lỗi xảy ra vui lòng thử lại";
		}
		return ResponseEntity.badRequest().body(message);
	}

}
