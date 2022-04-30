package com.herokuapp.realestatebk.exception;

import java.net.BindException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HandleException {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		ex.printStackTrace();
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	
	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleBindException(BindException e) {
	    String errorMessage = "Request không hợp lệ";
	    if (e.getBindingResult().hasErrors())
	        e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
	    return errorMessage;
	}

}
