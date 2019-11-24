package com.cg.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * DTO for request and response messages
 * @author Bhushan Sonawane
 *
 */
@Entity
@Table(name = "RequestResponseMaster")
@SequenceGenerator(name = "msg_seq", sequenceName = "msg_seq", allocationSize = 1)
public class RequestResponse {
	
	@Id
	@GeneratedValue(generator = "msg_seq")
	private int messageId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_number", nullable = false)
	private Ticket query;
	
	@Column(length = 100)
	private String message;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	@Column(length = 10)
	private String type;
	
	public RequestResponse() {
		this.timestamp = new Date();
	}
	
	public RequestResponse(int messageId, String message, Date timestamp, String type) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.timestamp = timestamp;
		this.type = type;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public Ticket getQuery() {
//		return query;
//	}

	public void setQuery(Ticket query) {
		this.query = query;
	}

}