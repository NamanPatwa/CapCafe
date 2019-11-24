package com.cg.exception;

/**
 * The exception thrown if Ticket Not Found condition
 * @author Bhushan Sonawane
 * @version 1.0
 */
public class TicketNotFoundException extends Exception {

	public TicketNotFoundException() {
		super();
	}

	public TicketNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TicketNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TicketNotFoundException(String message) {
		super(message);
	}

	public TicketNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
