package com.example.classicalmusic.exception.handler;

import com.example.classicalmusic.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ClassicalMusicGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException resourceNotFoundException, WebRequest request) {
		return handleExceptionInternal(resourceNotFoundException,
				resourceNotFoundException.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@Override
	public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), headers, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException methodArgumentNotValidException, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ResponseEntity<>(errors, headers, HttpStatus.BAD_REQUEST);
	}
}
