package com.cg.dto;

import java.time.LocalTime;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @author Team1
 * @version 1
 * Order Entity class having field with getter and setter
 *
 */
@Entity
@Table(name = "Orders")
@SequenceGenerator(name = "orderseq", sequenceName = "order_seq", allocationSize = 1)
public class Order {
	@Id
	@Column(name = "order_id", length = 50)
	@GeneratedValue(generator = "orderseq")
	private int orderId;

	@Column(name="Employee_Id",length = 20,nullable = false)
	private int employeeId;

	@Column(name = "Employee_Name", length=50,nullable = false)
	private String employeeName;

	@Column(name = "Employee_Address",length=50,nullable = false)
	private String employeeAddress;

	@Column(name = "Employee_Mail", length =40,nullable = false)
	private String employeeMail;

	@Column(name = "Employee_Phone", length =10,nullable = false)
	private String employeePhone;

	@Column(name = "TotalAmount",length =10,nullable = false)
	private double totalAmount;

	@Column(name = "paymentType",length =10,nullable = false)
	private String paymentType;

	@Temporal(TemporalType.DATE)
	@Column(name = "Date",nullable = false)
	private Date orderDate;

	@Column(name = "Time",nullable = false)
	private LocalTime time = LocalTime.now();

	@Column(name = "Location",length =20,nullable = false)
	private String location;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@Column(name = "Order_Details",nullable = false)
	private Set<OrderDetail> orderDetails;

	/**
	 * default constructor 
	 */
	public Order() {
		this.orderDate = new Date();
	}

	/**
	 * Getter method to set value of EmployeeID
	 * @return employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * Setter method to set the value of employeeId 
	 * @param employeeId 
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Getter method to get location 
	 * @return Location
	 */

	public String getLocation() {
		return location;
	}

	/**
	 * Setter method to set the location 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Getter method to get OrderId
	 * @return OrderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * Setter method to set OrderId
	 * @param orderId
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * Getter method to get Employee Name
	 * @return employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * Setter method to set the Employee name
	 * @param employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * Getter method to get employee Address
	 * @return employeeAddress
	 */
	public String getEmployeeAddress() {
		return employeeAddress;
	}

	/**
	 * Setter method to set employee address
	 * @param employeeAddress
	 */
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	/**
	 * getter method to get employee mail
	 * @return employeeMail
	 */
	public String getEmployeeMail() {
		return employeeMail;
	}

	/**
	 * setter method to set employee mail
	 * @param employeeMail
	 */
	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}

	/**
	 * Getter method to get employee phone
	 * @return employeePhone
	 */
	public String getEmployeePhone() {
		return employeePhone;
	}

	/**
	 * Setter method to set Employee Phone 
	 * @param employeePhone
	 */
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	/**
	 * getter method to get total ammount
	 * @return totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Setter method to set TotalAmount
	 * @param totalAmount
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * getter method to get payment Type
	 * @return paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * Setter method to set Payment Type
	 * @param paymentType
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * Getter method to get Order Date
	 * @return orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	

	/**
	 * Getter method to get current system time
	 * @return time
	 */
	public LocalTime getTime() {
		return time;
	}

	/**
	 * getter method to set OrderDetails
	 * @return orderDetails
	 */
	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * setter method to set Order Details
	 * @param orderDetails
	 */
	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
