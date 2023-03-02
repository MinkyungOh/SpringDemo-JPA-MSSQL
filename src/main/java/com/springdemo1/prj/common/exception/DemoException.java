package com.springdemo1.prj.common.exception;

import org.springframework.http.HttpStatus;

import com.springdemo1.prj.common.Constants;

public class DemoException extends Exception {

	private static final long serialVersionUID = 4663380430591151694L;
	
	private Constants.ExceptionClass exceptionClass;
	private HttpStatus httpStatus;
	
	public DemoException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
		super(exceptionClass.toString() + message);
		
		this.exceptionClass = exceptionClass;
		this.httpStatus = httpStatus;
	}
	
	public Constants.ExceptionClass getExceptionClass() {
		return this.exceptionClass;
	}
	
	public int getHttpStatusCode() {
		return this.httpStatus.value();
	}
	
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}
	
	public String getHttpStatusType() {
		return this.httpStatus.getReasonPhrase();
	}
}
