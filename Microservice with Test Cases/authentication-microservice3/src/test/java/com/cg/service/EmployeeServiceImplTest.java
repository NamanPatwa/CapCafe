package com.cg.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dto.Employee;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.exception.EmployeeNotSavedException;
import com.cg.exception.WrongPasswordException;
import com.cg.exception.WrongSecurityAnswerException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {

	@Autowired
	private EmployeeService service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private Employee employee1;
	private Employee employee2;
	private Employee employee3;
	
	@Before
	public void init(){
		employee1 = new Employee();
		employee1.setEmployeeId("2111");
		employee1.setEmployeeName("Asha");
		employee1.setEmployeePassword(passwordEncoder.encode("asha"));
		employee1.setEmployeeMail("asha@gmail.com");
		employee1.setEmployeePhone("9874561236");
		employee1.setEmployeeRole("ADMIN");
		employee1.setQuestion("First phone ?");
		employee1.setAnswer("Samsung");
		
		employee2 = new Employee();
		employee2.setEmployeeId("2222");
		employee2.setEmployeeName("Nilesh");
		employee2.setEmployeePassword(passwordEncoder.encode("nilesh"));
		employee2.setEmployeeMail("nilesh@gmail.com");
		employee2.setEmployeePhone("9874561236");
		employee2.setEmployeeRole("USER");
		employee2.setQuestion("First phone ?");
		employee2.setAnswer("Samsung");
		
		employee3 = new Employee();
		employee3.setEmployeeId("2333");
		employee3.setEmployeeName("Dhara");
		employee3.setEmployeePassword(passwordEncoder.encode("dhara"));
		employee3.setEmployeeMail("dhara@gmail.com");
		employee3.setEmployeePhone("9987456123");
		employee3.setEmployeeRole("USER");
		employee3.setQuestion("First phone ?");
		employee3.setAnswer("Samsung");
	}
	
	@Test
	public void testSignUp1() throws EmployeeNotSavedException {
		Employee emp = service.signUp(employee1);
		System.out.println(emp);
		assertEquals(emp.getEmployeeId(), employee1.getEmployeeId());
		assertEquals(emp.getEmployeeName(), employee1.getEmployeeName());
		assertEquals(emp.getEmployeePhone(), employee1.getEmployeePhone());
		assertEquals(emp.getEmployeeRole(), employee1.getEmployeeRole());
		assertEquals(emp.getAnswer(), employee1.getAnswer());
	}
	
	@Test
	public void testSignUp2() throws EmployeeNotSavedException {
		Employee emp = service.signUp(employee2);
		System.out.println(emp);
		assertEquals(emp.getEmployeeId(), employee2.getEmployeeId());
		assertEquals(emp.getEmployeeName(), employee2.getEmployeeName());
		assertEquals(emp.getEmployeePhone(), employee2.getEmployeePhone());
		assertEquals(emp.getEmployeeRole(), employee2.getEmployeeRole());
		assertEquals(emp.getAnswer(), employee2.getAnswer());
	}
	
	@Test
	public void testSignUp3() throws EmployeeNotSavedException {
		Employee emp = service.signUp(employee3);
		System.out.println(emp);
		assertEquals(emp.getEmployeeId(), employee3.getEmployeeId());
		assertEquals(emp.getEmployeeName(), employee3.getEmployeeName());
		assertEquals(emp.getEmployeePhone(), employee3.getEmployeePhone());
		assertEquals(emp.getEmployeeRole(), employee3.getEmployeeRole());
		assertEquals(emp.getAnswer(), employee3.getAnswer());
	}

	@Test
	public void testGetByCorrectId() throws EmployeeNotFoundException {
		Employee emp = service.getById("1001");
		assertEquals(emp.getAnswer(), "iphone");
	}
	
	@Test(expected = EmployeeNotFoundException.class)
	public void testGetByIncorrectId() throws EmployeeNotFoundException {
		Employee emp = service.getById("7898");
		assertEquals(emp.getAnswer(), employee1.getAnswer());
	}

	@Test
	public void testNewCorrectPassword() throws EmployeeNotFoundException, WrongPasswordException {
		boolean value = service.newPassword("8111", "neha", "swaroop");
		assertTrue(value);
		service.newPassword("8111", "swaroop", "neha");
	}

	@Test(expected = WrongPasswordException.class)
	public void testNewCorrectWrongPassword() throws EmployeeNotFoundException, WrongPasswordException {
		boolean value = service.newPassword("7111", "asha", "naman");
		assertFalse(value);
	}
	
	@Test
	public void testCorrectLogin() throws EmployeeNotFoundException, WrongPasswordException {
		Employee emp = service.login("7111", "swaroop");
		assertEquals(emp.getEmployeeId(), "7111");
		assertEquals(emp.getEmployeeName(), "Swaroop");
		}

	@Test(expected = EmployeeNotFoundException.class)
	public void testWrongLogin() throws EmployeeNotFoundException, WrongPasswordException {
		service.login("2349", "wxyz");
	}
	
	@Test
	public void testGetAll() throws EmployeeNotFoundException {
		List<Employee> emps = service.getAll();
		if(emps.size() != 0){
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	public void testForgotPassword() throws EmployeeNotFoundException, WrongSecurityAnswerException {
		assertTrue(service.forgotPassword("2111", "Samsung", "asha"));
	}
	
	@Test(expected = WrongSecurityAnswerException.class)
	public void testForgotWrongPassword() throws EmployeeNotFoundException, WrongSecurityAnswerException {
		service.forgotPassword("7777", "rgsdhg", "asha");
	}
	
	@Test(expected = EmployeeNotFoundException.class)
	public void testForgotWrongIdPassword() throws EmployeeNotFoundException, WrongSecurityAnswerException {
		service.forgotPassword("4536", "rgsdhg", "asha");
	}

}
