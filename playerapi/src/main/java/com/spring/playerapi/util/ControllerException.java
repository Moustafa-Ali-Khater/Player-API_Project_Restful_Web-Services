package com.spring.playerapi.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.playerapi.exception.StudentException;
import com.spring.playerapi.model.StudentError;


@ControllerAdvice
public class ControllerException {

	@ExceptionHandler
	public ResponseEntity<StudentError> getExNF(StudentException se) {
		StudentError s = new StudentError();
		s.setStatusCode(HttpStatus.NOT_FOUND.value());
		s.setMessage(se.getMessage());
		s.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentError>(s, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentError> getEx(Exception se) {
		StudentError s = new StudentError();
		s.setStatusCode(HttpStatus.BAD_REQUEST.value());
		s.setMessage(se.getMessage());
		s.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentError>(s, HttpStatus.BAD_REQUEST);
	}
}
