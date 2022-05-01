package com.herokuapp.realestatebk.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		ex.printStackTrace();
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder error = new StringBuilder();
		for (ObjectError objectError : ex.getAllErrors()) {
			error.append(objectError.getDefaultMessage());
			error.append(", ");
		}
		return ResponseEntity.badRequest().body(error);
	}

//	@ExceptionHandler(BindException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public String handleBindException(BindException e) {
//		e.printStackTrace();
//	    String errorMessage = "Request không hợp lệ";
//	    if (e.getBindingResult().hasErrors())
//	        e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
//	    return errorMessage;
//	}

}
