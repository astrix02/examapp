package com.exam.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ErrorValidacionDatosException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ErrorValidacionDatosException(String message) {
		super(message);
	}
	
	public ErrorValidacionDatosException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
