package com.springdemo1.prj.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo1.prj.common.Constants.ExceptionClass;
import com.springdemo1.prj.common.exception.DemoException;

@RestController
@RequestMapping("/api/v1/hello-api")
public class HelloController {
	
	private Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	// http://localhost:8080/api/v1/hello-api/log-test
	@PostMapping("/log-test")
	public void logTest() {
		logger.trace("Trace Log");
		logger.debug("Debug Log");
		logger.info("Info Log");
		logger.warn("Warn Log");
		logger.error("Error Log");
	}

	// http://localhost:8080/api/v1/hello-api/exception
	@PostMapping("/exception")
	public void exceptionTest() throws Exception {
		throw new Exception("test exception");
	}
	
	// http://localhost:8080/api/v1/hello-api/demoexception
	@PostMapping("/demoexception")
	public void demoExceptionTest() throws DemoException {
		throw new DemoException(ExceptionClass.PRODUCT, HttpStatus.BAD_REQUEST, "의도한 에러가 발생하였습니다.");
	}
	
	// Controller 내 ExceptionHandler가 우선순위
//	@ExceptionHandler(value = Exception.class)
//	public ResponseEntity<Map<String, String>> exceptionHandler(Exception e) {
//		HttpHeaders responseHeaders = new HttpHeaders();
//		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
//		
//		logger.info(e.getMessage());
//		logger.info("Controller 내 Exception 호출");
//		
//		Map<String, String> map = new HashMap<>();
//		map.put("error type", httpStatus.getReasonPhrase());
//		map.put("error code", "400");
//		map.put("message", "에러 발생");
//		
//		return new ResponseEntity<>(map, responseHeaders, httpStatus);
//	}
}
