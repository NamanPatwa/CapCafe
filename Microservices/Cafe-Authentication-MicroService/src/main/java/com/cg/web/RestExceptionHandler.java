package com.cg.web;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.exception.EmployeeNotFoundException;
import com.cg.exception.IllegalSecurityQuestionException;
import com.cg.exception.WrongPasswordException;
import com.cg.exception.WrongSecurityAnswerException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseBody
	public ResponseEntity<Object> HandleProductNotFound(EmployeeNotFoundException ex) {
		System.out.println("Exception: " + ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalSecurityQuestionException.class)
	@ResponseBody
	public ResponseEntity<Object> HandleIllegalSecurityQuestionException(IllegalSecurityQuestionException ex) {
		System.out.println("Exception: " + ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(WrongPasswordException.class)
	@ResponseBody
	public ResponseEntity<Object> HandleWrongPasswordException(WrongPasswordException ex) {
		System.out.println("Exception: " + ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(WrongSecurityAnswerException.class)
	@ResponseBody
	public ResponseEntity<Object> HandleWrongSecurityAnswerException(WrongSecurityAnswerException ex) {
		System.out.println("Exception: " + ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
