package com.contrato.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionBase extends Exception{

	private static final long serialVersionUID = 1L;

	private ExceptionMessage exceptionMessage;	

	public ExceptionBase(String message) {
		super(message);
		exceptionMessage = new ExceptionMessage();
		exceptionMessage.setMessage(message);
	}
	
	public ExceptionBase(String message, String errorCode) {
		super(message);
		exceptionMessage = new ExceptionMessage();
		exceptionMessage.setMessage(message);
		exceptionMessage.setErrorCode(errorCode);
	}
	public ExceptionBase(String message, HttpStatus errorCode) {
		super(message);
		exceptionMessage = new ExceptionMessage();
		exceptionMessage.setMessage(message);
		exceptionMessage.setErrorCode(errorCode.toString());
	}
	
	
	public ExceptionMessage getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(ExceptionMessage exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	
	
	
}
