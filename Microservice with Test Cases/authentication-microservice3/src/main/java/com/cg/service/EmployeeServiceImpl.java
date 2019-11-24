package com.cg.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.dto.Employee;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.exception.EmployeeNotSavedException;
import com.cg.exception.WrongPasswordException;
import com.cg.exception.WrongSecurityAnswerException;
import com.cg.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	static Logger myLogger =  Logger.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee signUp(Employee employee) throws EmployeeNotSavedException {
		myLogger.info("<<Sign-up of new Employee service>>");
		String password = employee.getEmployeePassword();
		String encodedPassword = passwordEncoder.encode(password);
		myLogger.info("BCrypting Password");
		employee.setEmployeePassword(encodedPassword);
		Employee emp;
		try {
			emp = repo.save(employee);
			myLogger.info("Employee Persisted");
		} catch (Exception e) {
			myLogger.error("Employee Persist Failed");
			throw new EmployeeNotSavedException("Unable to save. Something went wrong. Please try again");
		}
		return emp;
	}

	@Override
	public Employee getById(String id) throws EmployeeNotFoundException {
		myLogger.info("<<Employee get by id service>>");
		Employee employee;
		try {
			employee = repo.findById(id).get();
			myLogger.info("Employee found by ID: "+id);
		} catch (Exception e) {
			myLogger.error("Employee not found by ID: "+id);
			throw new EmployeeNotFoundException("Employee not found with id "+id);
		}
		return employee;
	}

	@Override
	public boolean newPassword(String id, String prevpass, String newpass)
			throws EmployeeNotFoundException, WrongPasswordException {
		myLogger.info("<<Set New Password service>>");
		Employee employee;
		try {
			employee = repo.findById(id).get();
			myLogger.info("Employee found by ID: "+id);
		} catch (Exception e) {
			myLogger.error("Employee not found by ID: "+id);
			throw new EmployeeNotFoundException("Employee not found with id "+id);
		}
		String employeeEncodedPassword = employee.getEmployeePassword();
		if (passwordEncoder.matches(prevpass, employeeEncodedPassword)) {
			myLogger.info("Previous password match successful");
			String newEncodedPassword = passwordEncoder.encode(newpass);
			myLogger.info("New password BCrypted");
			employee.setEmployeePassword(newEncodedPassword);
			repo.save(employee);
			myLogger.info("Password successfully saved");
			return true;
		} else {
			myLogger.error("Previous password does not match");
			throw new WrongPasswordException("Password does not match. Please enter valid password");
		}
	}

	@Override
	public Employee login(String id, String password) throws EmployeeNotFoundException, WrongPasswordException {
		myLogger.info("<<Employee Login service>>");
		Employee employee;
		try {
			employee = repo.findById(id).get();
			myLogger.info("Employee found by ID: "+id);
		} catch (Exception e) {
			myLogger.error("Employee not found by ID: "+id);
			throw new EmployeeNotFoundException("Employee not found with id "+id);
		}
		String encodedPassword = employee.getEmployeePassword();
		if (passwordEncoder.matches(password, encodedPassword)) {
			myLogger.info("Password match successful");
			return employee;
		} else {
			myLogger.error("Password does not match");
			throw new WrongPasswordException("Password does not match. Please enter valid password");
		}
	}

	@Override
	public boolean deleteById(String id) throws EmployeeNotFoundException {
		myLogger.info("<<Delete employee by ID service>>");
		Employee employee;
		try {
			employee = repo.findById(id).get();
			myLogger.info("Employee found by ID: "+id);
		} catch (Exception e) {
			myLogger.error("Employee not found by ID: "+id);
			throw new EmployeeNotFoundException("Employee not found with id "+id);
		}
		repo.delete(employee);
		myLogger.info("Employee successfully deleted: "+id);
		return true;
	}

	@Override
	public List<Employee> getAll() throws EmployeeNotFoundException {
		myLogger.info("<<Get all employees from database>>");
		List<Employee> employees;
		try {
			employees = repo.findAll();
			myLogger.info("All users fetched");
		} catch (Exception e) {
			myLogger.error("User list is empty");
			throw new EmployeeNotFoundException("User list is empty");
		}
		return employees;
	}

	@Override
	public String getSecurityQuestion(String id) throws EmployeeNotFoundException {
		myLogger.info("<<Get security question service>>");
		Employee employee;
		try {
			employee = repo.findById(id).get();
			myLogger.info("Employee found by ID: "+id);
		} catch (Exception e) {
			myLogger.error("Employee not found by ID: "+id);
			throw new EmployeeNotFoundException("Employee not found with id "+id);
		}
		myLogger.info("Question fetched");
		return employee.getQuestion();
	}

	@Override
	public boolean forgotPassword(String employeeId, String answer, String password) throws EmployeeNotFoundException, WrongSecurityAnswerException {
		myLogger.info("<<Forgot Password service>>");
		Employee employee;
		try {
			myLogger.info("Employee found by ID: "+employeeId);
			employee = repo.findById(employeeId).get();
		} catch (Exception e) {
			myLogger.error("Employee not found by ID: "+employeeId);
			throw new EmployeeNotFoundException("Employee not found with id "+employeeId);
		}
		if(!answer.equals(employee.getAnswer())){
			myLogger.error("Security answer does not match");
			throw new WrongSecurityAnswerException("Answer does not match");
		}
		String encodedPassword = passwordEncoder.encode(password);
		myLogger.info("Password BCrypted");
		employee.setEmployeePassword(encodedPassword);
		repo.save(employee);
		myLogger.info("New password set successful");
		return true;
	}

	

}
