package com.cg.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.exception.OrderCanNotBeSavedException;
import com.cg.exception.OrderNotFoundException;

/**
 * 
 * @author team 1
 * @version 1 Rest exception handler Class to handle custom exception
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<Object> HandleOrderNotFound(OrderNotFoundException ex) {
		System.out.println("Exception: " + ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(OrderCanNotBeSavedException.class)
	public ResponseEntity<Object> HandleOrderCanNotSave(OrderCanNotBeSavedException ex) {
		System.out.println("Exception: " + ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
