package com.springdemo1.prj.common;

public class Constants {
	
	public enum ExceptionClass {
		PRODUCT("Product"), ORDER("Order"), PROVIDER("Provider");
		
		private String exceptionClass;
		
		ExceptionClass(String exceptionClass) {this.exceptionClass = exceptionClass;}
		
		public String getExceptionClass() {return this.exceptionClass;}
		
		@Override
		public String toString() { return getExceptionClass() + " Exception. ";}
	}

}
