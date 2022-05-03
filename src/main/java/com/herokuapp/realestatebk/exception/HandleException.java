package com.herokuapp.realestatebk.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.herokuapp.realestatebk.util.UniqueDatabase;

@ControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RealEsateException.class)
	public ResponseEntity<String> handleRealEsateException(Exception ex) {
		ex.printStackTrace();
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ex.printStackTrace();
		StringBuilder error = new StringBuilder();
		for (ObjectError objectError : ex.getAllErrors()) {
			error.append(objectError.getDefaultMessage());
			error.append(", ");
		}
		return ResponseEntity.badRequest().body(error);
	}

	@ExceptionHandler(SQLSyntaxErrorException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleBindException(SQLSyntaxErrorException e) {
		e.printStackTrace();
		if (e.getMessage().contains("max_questions")) {
			return "Server hiện tại đã quá tải vui lòng thử lại sau";
		}
		return e.getMessage();
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
