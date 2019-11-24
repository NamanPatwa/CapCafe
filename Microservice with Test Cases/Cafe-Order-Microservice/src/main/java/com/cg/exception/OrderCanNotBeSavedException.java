package com.cg.exception;

/**
 * 
 * @author Team1
 * @version 1 Exception Class to handle exception During Persisting Order
 *
 */
public class OrderCanNotBeSavedException extends Exception {
	/**
	 * 
	 */
	public OrderCanNotBeSavedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public OrderCanNotBeSavedException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public OrderCanNotBeSavedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param message
	 */
	public OrderCanNotBeSavedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param cause
	 */
	public OrderCanNotBeSavedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
