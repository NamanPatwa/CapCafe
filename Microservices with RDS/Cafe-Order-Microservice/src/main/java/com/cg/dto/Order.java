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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Orders")
@SequenceGenerator(name = "orderseq",sequenceName = "order_seq", allocationSize = 1)
public class Order {
	@Id
    @Column(name = "order_id", length = 50)
	@GeneratedValue(generator = "orderseq")
    private int orderId;
	
	private int employeeId;
 
	@Column(name = "Employee_Name", length = 255)
    private String employeeName;
	
	@Column(name = "Employee_Address", length = 255)
    private String employeeAddress;
	
	@Column(name = "Employee_Mail", length = 128)
	private String employeeMail;
	
	@Column(name = "Employee_Phone", length = 128)
	private String employeePhone;
	
    @Column(name = "TotalAmount")
    private double totalAmount;
    
    @Column(name="paymentType")
    private String paymentType;
    
	@Temporal(TemporalType.DATE)
    @Column(name = "Date")
    private Date orderDate;
    
    @Column(name = "Time")
    private LocalTime time = LocalTime.now();
    
    @Column(name="Location")
    private String location;
    
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    @Column(name = "Order_Details")
    private Set<OrderDetail> orderDetails;
    /**
     * 
     */
    public Order() {
		this.orderDate=new Date();
	}
    /**
     * 
     * @return
     */ 
public int getEmployeeId() {
		return employeeId;
	}
/**
 * 
 * @param employeeId
 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

/**
 * 
 * @return
 */


	public String getLocation() {
		return location;
	}

/**
 * 
 * @param location
 */
	public void setLocation(String location) {
		this.location = location;
	}
/**
 * 
 * @return
 */
	public int getOrderId() {
		return orderId;
	}
/**
 * 
 * @param orderId
 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
/**
 * 
 * @return
 */
	public String getEmployeeName() {
		return employeeName;
	}
/**
 * 
 * @param employeeName
 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
/**
 * 
 * @return
 */
	public String getEmployeeAddress() {
		return employeeAddress;
	}
/**
 * 
 * @param employeeAddress
 */
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
/**
 * 
 * @return
 */
	public String getEmployeeMail() {
		return employeeMail;
	}
/**
 * 
 * @param employeeMail
 */
	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}
/**
 * 
 * @return
 */
	public String getEmployeePhone() {
		return employeePhone;
	}
/**
 * 
 * @param employeePhone
 */
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
/**
 * 
 * @return
 */
	public double getTotalAmount() {
		return totalAmount;
	}
/**
 * 
 * @param totalAmount
 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
/**
 * 
 * @return
 */
	public String getPaymentType() {
		return paymentType;
	}
/**
 * 
 * @param paymentType
 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
/**
 * 
 * @return
 */
	public Date getOrderDate() {
		return orderDate;
	}
/**
 * 
 * @param orderDate
 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
/**
 * 
 * @return
 */
	public LocalTime getTime() {
		return time;
	}
/**
 * 
 * @param time
 */
	public void setTime(LocalTime time) {
		this.time = time;
	}
/**
 * 
 * @return
 */
	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
/**
 * 
 * @param orderDetails
 */
	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
    
    
}
