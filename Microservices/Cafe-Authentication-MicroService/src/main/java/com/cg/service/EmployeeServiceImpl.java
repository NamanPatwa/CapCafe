package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.dto.Employee;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.exception.EmployeeNotSavedException;
import com.cg.exception.IllegalSecurityQuestionException;
import com.cg.exception.WrongPasswordException;
import com.cg.exception.WrongSecurityAnswerException;
import com.cg.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee signUp(Employee employee) throws EmployeeNotSavedException {
		String password = employee.getEmployeePassword();
		String encodedPassword = passwordEncoder.encode(password);
		employee.setEmployeePassword(encodedPassword);
		Employee emp = repo.save(employee);
		if(emp == null)
			throw new EmployeeNotSavedException("Unable to save. Something went wrong. Please try again");
		return emp;
	}

	@Override
	public Employee getById(String id) throws EmployeeNotFoundException {
		Employee employee;
		try {
			employee = repo.findById(id).get();
		} catch (Exception e) {
			throw new EmployeeNotFoundException("Employee not found with id "+id);
		}
		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public boolean newPassword(String id, String prevpass, String newpass)
			throws EmployeeNotFoundException, WrongPasswordException {
		Employee employee;
		try {
			employee = repo.findById(id).get();
		} catch (Exception e) {
			throw new EmployeeNotFoundException("Employee not found with id "+id);
		}
		String employeeEncodedPassword = employee.getEmployeePassword();
		if (passwordEncoder.matches(prevpass, employeeEncodedPassword)) {
			String newEncodedPassword = passwordEncoder.encode(newpass);
			employee.setEmployeePassword(newEncodedPassword);
			repo.save(employee);
			System.out.println("passs");
			return true;
		} else {
			throw new WrongPasswordException("Password does not match. Please enter valid password");
		}
	}

	@Override
	public Employee login(String id, String password) throws EmployeeNotFoundException, WrongPasswordException {
		Employee employee;
		try {
			employee = repo.findById(id).get();
		} catch (Exception e) {
			throw new EmployeeNotFoundException("Employee not found with id "+id);
		}
		String encodedPassword = employee.getEmployeePassword();
		if (passwordEncoder.matches(password, encodedPassword)) {
			return employee;
		} else {
			throw new WrongPasswordException("Password does not match. Please enter valid password");
		}
	}

	@Override
	public boolean deleteById(String id) throws EmployeeNotFoundException {
		Employee employee;
		try {
			employee = repo.findById(id).get();
		} catch (Exception e) {
			throw new EmployeeNotFoundException("Employee not found with id "+id);
		}
		repo.delete(employee);
		return true;
	}

	@Override
	public List<Employee> getAll() throws EmployeeNotFoundException {
		try {
			return repo.findAll();
		} catch (Exception e) {
			throw new EmployeeNotFoundException("User list is empty");
		}
	}

	@Override
	public String getSecurityQuestion(String id) throws EmployeeNotFoundException {
		Employee employee;
		try {
			employee = repo.findById(id).get();
		} catch (Exception e) {
			throw new EmployeeNotFoundException("Employee not found with id "+id);
		}
		return employee.getQuestion();
	}

	@Override
	public boolean forgotPassword(String employeeId, String answer, String password) throws EmployeeNotFoundException, WrongSecurityAnswerException {
		Employee employee;
		try {
			employee = repo.findById(employeeId).get();
		} catch (Exception e) {
			throw new EmployeeNotFoundException("Employee not found with id "+employeeId);
		}
		if(!answer.equals(employee.getAnswer())){
			throw new WrongSecurityAnswerException("Answer does not match");
		}
		String encodedPassword = passwordEncoder.encode(password);
		employee.setEmployeePassword(encodedPassword);
		repo.save(employee);
		return true;
	}

	

}
