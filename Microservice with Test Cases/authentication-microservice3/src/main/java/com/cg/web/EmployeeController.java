package com.cg.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.Employee;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.exception.EmployeeNotSavedException;
import com.cg.exception.IllegalSecurityQuestionException;
import com.cg.exception.WrongPasswordException;
import com.cg.exception.WrongSecurityAnswerException;
import com.cg.service.EmployeeService;
import com.cg.service.EmployeeServiceImpl;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/capcafe")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	static Logger myLogger =  Logger.getLogger(EmployeeServiceImpl.class);
	
	@PostMapping(value = "/add")
	public Employee addEmployee(@RequestBody Employee employee) throws EmployeeNotSavedException {
		myLogger.info("================================================");
		myLogger.info("POST MAPPING REQUEST for SIGN-UP");
		return service.signUp(employee);
	}

	@GetMapping(value = "/id/{id}")
	public Employee getById(@PathVariable String id) throws EmployeeNotFoundException {
		myLogger.info("================================================");
		myLogger.info("GET MAPPING REQUEST to GET employee by ID");
		return service.getById(id);
	}

	@PutMapping(value = "/chng/{id}/{prevpass}/{newpass}")
	public boolean newPassword(@PathVariable String id, @PathVariable String prevpass, @PathVariable String newpass)
			throws EmployeeNotFoundException, WrongPasswordException {
		myLogger.info("================================================");
		myLogger.info("PUT MAPPING REQUEST to RESET password");
		return service.newPassword(id, prevpass, newpass);
	}

	@GetMapping(value = "/login/{id}/{password}")
	public Employee login(@PathVariable String id, @PathVariable String password)
			throws EmployeeNotFoundException, WrongPasswordException {
		myLogger.info("================================================");
		myLogger.info("GET MAPPING REQUEST for LOG-IN");
		return service.login(id, password);
	}

	@GetMapping(value = "/all")
	public List<Employee> getAll() throws EmployeeNotFoundException {
		myLogger.info("================================================");
		myLogger.info("GET MAPPING REQUEST to get all users");
		return service.getAll();
	}

	@GetMapping(value = "/question/{id}")
	public String getSecurityQuestion(@PathVariable String id) throws EmployeeNotFoundException{
		myLogger.info("================================================");
		myLogger.info("GET MAPPING REQUEST for security question");
		return service.getSecurityQuestion(id);
	}
	
	@PutMapping(value = "/forgotpass/{employeeId}/{answer}/{password}")
	public boolean forgotPassword(@PathVariable String employeeId,@PathVariable String answer,@PathVariable String password) throws EmployeeNotFoundException, WrongSecurityAnswerException{
		myLogger.info("================================================");
		myLogger.info("PUT MAPPING REQUEST for forgot password");
		return service.forgotPassword(employeeId, answer, password);
	}
}
