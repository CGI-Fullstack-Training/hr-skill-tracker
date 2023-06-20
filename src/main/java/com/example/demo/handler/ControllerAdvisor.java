package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.model.AssociateNotFoundException;
import com.example.demo.model.ErrorResponseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor extends RuntimeException {

	@ExceptionHandler(value = NumberFormatException.class)
	public ResponseEntity<ErrorResponseModel> handleException(NumberFormatException e) {
		ErrorResponseModel errorModel = new ErrorResponseModel(e.getMessage(), HttpStatus.BAD_REQUEST.value(),
				System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorModel);
	}

	@ExceptionHandler(value = AssociateNotFoundException.class)
	public ResponseEntity<ErrorResponseModel> handleAssociateNotFoundException(AssociateNotFoundException e) {
		ErrorResponseModel errorModel = new ErrorResponseModel(e.getMessage(), HttpStatus.NOT_FOUND.value(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorModel);

	}

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<ErrorResponseModel> handleIllegalArgumentException(IllegalArgumentException e) {
		log.info("hello ::::  " + e.toString());
		ErrorResponseModel errorModel = new ErrorResponseModel("Illegal argument passed",
				HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorModel);

	}
}
