package com.cg.cafedetails.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Employee_Master")
public class Employee {

	@Id
	@Column(name = "Employee_Id", length = 20)
	@NotEmpty(message = "Employee id cannot be empty")
	@Size(max = 20, message = "max size of employee id is 20")
	private String employeeId;
	
	@Column(name = "Employee_Name", length = 20)
	@NotEmpty(message = "Employee name cannot be empty")
	@Size(max = 20, message = "max size of Employee name is 20")
	private String employeeName;
	
	@Column(name = "Employee_Password", length = 256)
	@NotEmpty(message = "Password cannot be empty")
	@Size(max = 256, message = "max size of Password is 256")
	private String employeePassword;
	
	@Column(name = "Employee_Phone", length = 20)
	@NotEmpty(message = "Employee phone number cannot be empty")
	@Size(max = 20, message = "max size of phone numbe is 20")
	private String employeePhone;
	
	@Column(name = "Employee_Mail", length = 50)
	@NotEmpty(message = "Employee mail cannot be empty")
	@Size(max = 50, message = "max size of Employee mail is 50")
	private String employeeMail;
	
	@Column(name = "Employee_Role", length = 20)
	@NotEmpty(message = "Employee role cannot be empty")
	@Size(max = 20, message = "max size of Employee role is 20")
	private String employeeRole;
	
	@Column(name = "Question", length = 50)
	@NotEmpty(message = "Question id cannot be empty")
	@Size(max = 50, message = "max size of Question is 50")
	private String question;
	
	@Column(name = "Answer", length = 50)
	@NotEmpty(message = "Answer cannot be empty")
	@Size(max = 50, message = "max size of Answer is 50")
	private String answer;

	public Employee() {
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeMail() {
		return employeeMail;
	}

	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String questionId) {
		this.question = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
