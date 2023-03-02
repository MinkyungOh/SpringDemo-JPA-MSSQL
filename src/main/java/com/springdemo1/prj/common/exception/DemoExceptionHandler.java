package com.springdemo1.prj.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DemoExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(DemoExceptionHandler.class);
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Map<String, String>> exceptionHandler(Exception e) {
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		
		logger.info(e.getLocalizedMessage());
		logger.info("Advice 내 Exception 호출");
		
		Map<String, String> map = new HashMap<>();
		map.put("error type", httpStatus.getReasonPhrase());
		map.put("error code", "400");
		map.put("message", "에러 발생");
		
		return new ResponseEntity<>(map, responseHeaders, httpStatus);
	}
	
	@ExceptionHandler(value = DemoException.class)
	public ResponseEntity<Map<String, String>> exceptionHandler(DemoException e) {
		HttpHeaders responseHeaders = new HttpHeaders();
		
		logger.info(e.getLocalizedMessage());
		logger.info("Advice 내 Exception 호출");
		
		Map<String, String> map = new HashMap<>();
		map.put("error type", e.getHttpStatusType());
		map.put("error code", Integer.toString(e.getHttpStatusCode()));
		map.put("message", e.getMessage());
		
		return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
	}
}
