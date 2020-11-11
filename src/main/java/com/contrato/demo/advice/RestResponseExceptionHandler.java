package com.contrato.demo.advice;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.contrato.demo.exceptions.ExceptionBase;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestResponseExceptionHandler {

	@ExceptionHandler(value = {ExceptionBase.class})
	protected ResponseEntity<?> handleServicioException(ExceptionBase ex){
		return ResponseEntity.status(obtenerStatus(ex)).body(ex.getMessage());
	}
	
	@ExceptionHandler(value = {Throwable.class})
	protected ResponseEntity<?> handleException(Throwable ex){
		return ResponseEntity.status(obtenerStatus(ex)).body(ex.getMessage());
	}
	
	private HttpStatus obtenerStatus(Throwable ex) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ResponseStatus responseStatus = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
		
		if(null != responseStatus) {
			status = responseStatus.value();
		}
		
		return status;
	}
	
}
