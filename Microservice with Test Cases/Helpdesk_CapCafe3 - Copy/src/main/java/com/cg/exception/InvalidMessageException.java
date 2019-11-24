package com.cg.exception;

/**
 * Exception for Invalid Message Inputs
 * @author Bhushan Sonawane
 * @version 1.0
 */
public class InvalidMessageException extends Exception{

	public InvalidMessageException() {
		super();
	}

	public InvalidMessageException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidMessageException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidMessageException(String message) {
		super(message);
	}

	public InvalidMessageException(Throwable cause) {
		super(cause);
	}
	
}
