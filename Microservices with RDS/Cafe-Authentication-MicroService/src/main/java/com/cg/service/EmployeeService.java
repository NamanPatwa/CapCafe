package com.cg.service;

import java.util.List;

import com.cg.dto.Employee;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.exception.EmployeeNotSavedException;
import com.cg.exception.IllegalSecurityQuestionException;
import com.cg.exception.WrongPasswordException;
import com.cg.exception.WrongSecurityAnswerException;

public interface EmployeeService {
	Employee signUp(Employee employee) throws EmployeeNotSavedException;

	Employee getById(String id) throws EmployeeNotFoundException;

	Employee update(Employee employee);

	boolean newPassword(String id, String prevpass, String newpass)
			throws EmployeeNotFoundException, WrongPasswordException;

	boolean deleteById(String id) throws EmployeeNotFoundException;

	boolean forgotPassword(String employeeId, String answer, String password) throws EmployeeNotFoundException, WrongSecurityAnswerException;

	Employee login(String id, String password) throws EmployeeNotFoundException, WrongPasswordException;

	List<Employee> getAll() throws EmployeeNotFoundException;
	
	String getSecurityQuestion(String id) throws EmployeeNotFoundException;

}
