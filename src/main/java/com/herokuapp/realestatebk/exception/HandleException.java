package com.herokuapp.realestatebk.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleException(Exception ex) {
//		return ResponseEntity.badRequest().body(ex.getMessage());
//	}

}
