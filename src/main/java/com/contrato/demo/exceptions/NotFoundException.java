package com.contrato.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends ExceptionBase{

	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super(message, HttpStatus.NOT_FOUND);
	}

}
