package com.cg.cafedetails.dto;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "ticket_master")
@SequenceGenerator(name = "token_seq", sequenceName = "token_seq", allocationSize = 1)
public class Ticket {
	
	@Id
	@GeneratedValue(generator = "token_seq")
	private int ticketNumber;
	
	@Column(length = 10)
	private String status;
	
	private Date date;
	
	@Column(length = 10)
	private String location;
	
	@OneToMany(mappedBy = "query", fetch = FetchType.LAZY)
	private Set<RequestResponse> messages;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "order_id", unique = true)
	private Order order;
	
	
	public Ticket() {
		this.status = "Unresolved";
		this.date = new Date(new java.util.Date().getTime());
	}
	
	public Ticket(int tokenNumber, String status, Date date, String location, Set<RequestResponse> messages) {
		super();
		this.ticketNumber = tokenNumber;
		this.status = status;
		this.date = date;
		this.location = location;
		this.messages = messages;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<RequestResponse> getMessages() {
		return messages;
	}

	public void setMessages(Set<RequestResponse> messages) {
		this.messages = messages;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}