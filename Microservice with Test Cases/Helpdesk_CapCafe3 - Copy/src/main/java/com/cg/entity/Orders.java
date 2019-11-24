package com.cg.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Entity for orders placed
 * @author Bhushan Sonawane
 *
 */
@Entity
@Table(name = "orders")
public class Orders{
	
	@Id
	private int orderId;
	private int quantity;
	
	@Column(length = 10)
	private String paymentType;

	private double amount;
	
	@Column(length = 10)
	private String address;
	
	@Column(length = 10)
	private String location;
	
	private Date orderDate;
	
	public Orders() {
	}
	
	public Orders(int orderId, int quantity, String paymentType, double amount, String address, String location,
			Date orderDate) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.paymentType = paymentType;
		this.amount = amount;
		this.address = address;
		this.location = location;
		this.orderDate = orderDate;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
}