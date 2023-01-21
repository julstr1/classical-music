package com.example.classicalmusic.exception.handler;

import com.example.classicalmusic.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClassicalMusicGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException resourceNotFoundException, WebRequest request) {
		return handleExceptionInternal(resourceNotFoundException,
				resourceNotFoundException.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
